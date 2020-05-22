import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Locale;
import javax.imageio.*;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

public class CompressImage {

    /** TODO: This method has terrible handling of I/O.  
     Rewrite for production use. BNI. */
    static public void saveJpegCompressedImage(
            BufferedImage image,
            float quality,
            File file) throws Exception {
        OutputStream outStream = new FileOutputStream(
                new File(file, "Image-" + quality + ".jpg"));

        ImageWriter imgWriter = ImageIO.
                getImageWritersByFormatName("jpg").next();
        ImageOutputStream ioStream = 
                ImageIO.createImageOutputStream(outStream);
        imgWriter.setOutput(ioStream);

        JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(
                Locale.getDefault());
        jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpegParams.setCompressionQuality(quality);

        imgWriter.write(null, new IIOImage(image, null, null), jpegParams);

        ioStream.flush();
        ioStream.close();
        imgWriter.dispose();
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://i.stack.imgur.com/7bI1Y.jpg");
        File f = new File(System.getProperty("user.home"));
        BufferedImage bi = ImageIO.read(url);
        for (float q = 0.2f; q < .9f; q += .2f) {
            saveJpegCompressedImage(bi, q, f);
        }
        Desktop.getDesktop().open(f);
    }
}