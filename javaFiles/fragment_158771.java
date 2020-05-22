import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.jpeg.JpegDirectory;

public class Main {

    private static String inFilePath = "C:\\Users\\TapasB\\Desktop\\MHIS031522.jpg";
    private static String outFilePath = "C:\\Users\\TapasB\\Desktop\\MHIS031522-rotated.jpg";

    public static void main(String[] args) throws Exception {
        File imageFile = new File(inFilePath);
        BufferedImage originalImage = ImageIO.read(imageFile);

        Metadata metadata = ImageMetadataReader.readMetadata(imageFile);
        ExifIFD0Directory exifIFD0Directory = metadata.getDirectory(ExifIFD0Directory.class);
        JpegDirectory jpegDirectory = (JpegDirectory) metadata.getDirectory(JpegDirectory.class);

        int orientation = 1;
        try {
            orientation = exifIFD0Directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        int width = jpegDirectory.getImageWidth();
        int height = jpegDirectory.getImageHeight();

        AffineTransform affineTransform = new AffineTransform();

        switch (orientation) {
        case 1:
            break;
        case 2: // Flip X
            affineTransform.scale(-1.0, 1.0);
            affineTransform.translate(-width, 0);
            break;
        case 3: // PI rotation
            affineTransform.translate(width, height);
            affineTransform.rotate(Math.PI);
            break;
        case 4: // Flip Y
            affineTransform.scale(1.0, -1.0);
            affineTransform.translate(0, -height);
            break;
        case 5: // - PI/2 and Flip X
            affineTransform.rotate(-Math.PI / 2);
            affineTransform.scale(-1.0, 1.0);
            break;
        case 6: // -PI/2 and -width
            affineTransform.translate(height, 0);
            affineTransform.rotate(Math.PI / 2);
            break;
        case 7: // PI/2 and Flip
            affineTransform.scale(-1.0, 1.0);
            affineTransform.translate(-height, 0);
            affineTransform.translate(0, width);
            affineTransform.rotate(3 * Math.PI / 2);
            break;
        case 8: // PI / 2
            affineTransform.translate(0, width);
            affineTransform.rotate(3 * Math.PI / 2);
            break;
        default:
            break;
        }       

        AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);  
        BufferedImage destinationImage = new BufferedImage(originalImage.getHeight(), originalImage.getWidth(), originalImage.getType());
        destinationImage = affineTransformOp.filter(originalImage, destinationImage);
        ImageIO.write(destinationImage, "jpg", new File(outFilePath));
    }
}