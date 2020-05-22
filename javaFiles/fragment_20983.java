import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Image;

import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageManipulation {

    public static void main(String[] args) throws Exception {
        File infile = new File("/your image.jpg");
        File outfile = new File("/your image.jpg");

        ImageReader reader = ImageIO.getImageReadersByFormatName("jpeg").next();
        reader.setInput(new FileImageInputStream(infile), true, false);
        IIOMetadata data = reader.getImageMetadata(0);
        BufferedImage image = reader.read(0);

        int w = 600, h = -1;
         Image rescaled = image.getScaledInstance(w, h, Image.SCALE_AREA_AVERAGING);
         BufferedImage output = toBufferedImage(rescaled, BufferedImage.TYPE_INT_RGB);

        Element tree = (Element) data.getAsTree("javax_imageio_jpeg_image_1.0");
        Element jfif = (Element) tree.getElementsByTagName("app0JFIF").item(0);
        for (int i = 0; i < jfif.getAttributes().getLength(); i++) {
            Node attribute = jfif.getAttributes().item(i);
            System.out.println(attribute.getNodeName() + "="
                    + attribute.getNodeValue());
        }
        FileOutputStream fos = new FileOutputStream(outfile);
        JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(fos);
        JPEGEncodeParam jpegEncodeParam = jpegEncoder.getDefaultJPEGEncodeParam(output);
        jpegEncodeParam.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
        jpegEncodeParam.setXDensity(300);
        jpegEncodeParam.setYDensity(300);
        jpegEncoder.encode(output, jpegEncodeParam);
        fos.close();
        }

      public static BufferedImage toBufferedImage(Image image, int type) {
            int w = image.getWidth(null);
            int h = image.getHeight(null);
            BufferedImage result = new BufferedImage(w, h, type);
            Graphics2D g = result.createGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
            return result;
        }
}