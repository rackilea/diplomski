import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class SimpleConvertImage2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*
         * 1. How to convert an image file to  byte array?
         */

        File file = new File("C:\\rose.jpg");

        FileInputStream fis = new FileInputStream(file);
        //create FileInputStream which obtains input bytes from a file in a file system
        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.

        ByteArrayOutputStream bos = new ByteArrayOutputStream();


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //InputStream is = url.openStream();
        byte[] b = new byte[2^16];
        int read = fis.read(b);

        while (read > -1) {
            baos.write(b, 0, read);
            read = fis.read(b);
        }

        int size = baos.toByteArray().length;

        System.out.println("image size original code : " + size);


    }
}