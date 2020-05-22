package imageprocessor;

 import java.awt.Graphics2D;
 import java.awt.Rectangle;
 import java.awt.geom.AffineTransform;
 import java.awt.image.BufferedImage;
 import java.io.File;
 import java.util.UUID;

 import javax.imageio.ImageIO;
 import javax.swing.UIManager;

 import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
 import com.amazonaws.services.lambda.runtime.Context;
 import com.amazonaws.services.lambda.runtime.RequestHandler;
 import com.amazonaws.services.s3.AmazonS3Client;
 import com.amazonaws.services.s3.model.CannedAccessControlList;
 import com.amazonaws.services.s3.model.GetObjectRequest;
 import com.amazonaws.services.s3.model.PutObjectRequest;


 public class LambdaImageProcessor implements RequestHandler<String, String> {

    private static final String filePath = "/tmp/";
    private static File localFile, outputfileCropped, outputfileRotated, outputfileSized;
     private static final float xsize = 500;   //max width for resize
     private static final float ysize = 500;   //max height for resize

     @Override
     public String handleRequest(String input, Context context) {

        AmazonS3Client s3Client = new AmazonS3Client(
                 new DefaultAWSCredentialsProviderChain());

         context.getLogger().log("Input: " + input + "\n");

         try
         {
            String[] arr = input.split(",");
            String sourceBucket = arr[0];
            String key = arr[1];
             String destBucket = arr[2];
             String permission = arr[3];

            //download
             context.getLogger().log("AWS S3 downloading image\n");
            GetObjectRequest downloadReq = new GetObjectRequest(sourceBucket, key);

            String uniqueID = UUID.randomUUID().toString().replaceAll("-", "");
            localFile = new File(filePath + uniqueID + "_" + key);
            outputfileCropped = new File(filePath + uniqueID + "_" + "c_" + key);
            outputfileRotated = new File(filePath + uniqueID + "_" + "r_" + key);
            outputfileSized = new File(filePath + uniqueID + "_" + "s_" + key);

            if(localFile.exists())
            {
                localFile.delete();
            }
            if(outputfileCropped.exists())
            {
                outputfileCropped.delete();
            }
            if(outputfileRotated.exists())
            {
                outputfileRotated.delete();
            }

            context.getLogger().log("File name - " + localFile.toString() + "\n");
            s3Client.getObject(downloadReq, localFile);      
            context.getLogger().log("AWS S3 download - Done\n");

            //upload
            if(localFile.exists())
            {
                //context.getLogger().log("AWS S3 cropping image\n");

                BufferedImage bufferedImage = ImageIO.read(localFile);  

                BufferedImage resizeBuffered = resizeImage(bufferedImage, xsize, ysize);
                //ImageIO.write(resizeBuffered, "jpg", outputfileSized);    
                context.getLogger().log("AWS S3 Resize - Done\n");

                Rectangle rect = new Rectangle(100, 100, 300, 150);
                BufferedImage cropBuffered = cropImage(resizeBuffered, rect);
                context.getLogger().log("AWS S3 Crop - Done\n");

                ImageIO.write(rotateImage(cropBuffered, 90), "jpg", outputfileRotated);
                context.getLogger().log("AWS S3 Rotate - Done\n");

                context.getLogger().log("AWS S3 uploading image\n");
                PutObjectRequest uploadReq = new PutObjectRequest(destBucket, key, outputfileRotated);        

                if(permission.toUpperCase().equals("PUBLIC"))
                {
                    uploadReq.setCannedAcl(CannedAccessControlList.PublicRead);
                }
                else if(permission.toUpperCase().equals("PRIVATE"))
                {
                    uploadReq.setCannedAcl(CannedAccessControlList.Private);
                }
                s3Client.putObject(uploadReq);
                context.getLogger().log("AWS S3 upload - Done\n");
            }
            else
            {
                context.getLogger().log("Downloaded file not found\n");
            }
            return context.getAwsRequestId();
         }
         catch (Exception ex)
         {
            context.getLogger().log("Exception - " + ex.getMessage().toString() + " " + ex.getStackTrace().toString() + "\n");
            return "Exception - " + ex.getMessage().toString() + " " + ex.getStackTrace().toString();
         }
         finally 
         {          
            if(localFile.exists())
            {
                localFile.delete();
                context.getLogger().log("Temp Local File Deleted\n");
            }  
            if(outputfileCropped.exists())
            {
                outputfileCropped.delete();
                context.getLogger().log("Temp Cropped File Deleted\n");
            }
            if(outputfileRotated.exists())
            {
                outputfileRotated.delete();
                context.getLogger().log("Temp Rotated File Deleted\n");
            }
            if(outputfileSized.exists())
            {
                outputfileSized.delete();
                context.getLogger().log("Temp ReSized File Deleted\n");
            }
        }
     }

     private static BufferedImage cropImage(BufferedImage src, Rectangle rect) {
       BufferedImage dest = src.getSubimage(rect.x, rect.y, rect.width, rect.height);
       return dest; 
    }

     private static BufferedImage rotateImage(BufferedImage bufferedImage, int angle) { 

        double theta = Math.toRadians(angle);
        double cos = Math.abs(Math.cos(theta));
         double sin = Math.abs(Math.sin(theta));
         double width  = bufferedImage.getWidth();
         double height = bufferedImage.getHeight();
         int w = (int)(width * cos + height * sin);
         int h = (int)(width * sin + height * cos);

         BufferedImage out = new BufferedImage(w, h, bufferedImage.getType());
         Graphics2D g2 = out.createGraphics();
         g2.setPaint(UIManager.getColor("Panel.background"));
         g2.fillRect(0,0,w,h);
         double x = w/2;
         double y = h/2;
         AffineTransform at = AffineTransform.getRotateInstance(theta, x, y);
         x = (w - width)/2;
         y = (h - height)/2;
         at.translate(x, y);
         g2.drawRenderedImage(bufferedImage, at);
         g2.dispose();
         return out; 
    }

     private static BufferedImage resizeImage(BufferedImage bufferedImage, float sizeX, float sizeY)
    {
        float ratioX = sizeX / bufferedImage.getWidth();
        float ratioY = sizeY / bufferedImage.getHeight();
        float ratio = Math.min(ratioX, ratioY);

        float newX = bufferedImage.getWidth() * ratio;
        float newY = bufferedImage.getHeight() * ratio;

        BufferedImage resizedImage = new BufferedImage((int)newX, (int)newY, bufferedImage.getType());
         Graphics2D g = resizedImage.createGraphics();
         g.drawImage(bufferedImage, 0, 0, (int)newX, (int)newY, null);
         g.dispose();

         return resizedImage;

    }

 }