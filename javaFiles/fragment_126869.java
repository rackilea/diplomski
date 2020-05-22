package com.pdfrenderer.examples;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.imageio.ImageIO;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

public class ConvertAllPDFPagesToImageWithDimenstions {
    public static void main(String[] args) {
        try {
            String sourceDir = "C:/Documents/04-Request-Headers.pdf";// PDF file must be placed in DataGet folder
            String destinationDir = "C:/Documents/Converted/";//Converted PDF page saved in this folder

        File sourceFile = new File(sourceDir);
        File destinationFile = new File(destinationDir);

        String fileName = sourceFile.getName().replace(".pdf", "");
        if (sourceFile.exists()) {
            if (!destinationFile.exists()) {
                destinationFile.mkdir();
                System.out.println("Folder created in: "+ destinationFile.getCanonicalPath());
            }

            RandomAccessFile raf = new RandomAccessFile(sourceFile, "r");
            FileChannel channel = raf.getChannel();
            ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            PDFFile pdf = new PDFFile(buf);
            System.out.println("Total Pages: "+ pdf.getNumPages());
            int pageNumber = 1;
            for (int i = 0; i < pdf.getNumPages(); i++) {
                PDFPage page = pdf.getPage(i);

                // image dimensions 
                int width = 1200;
                int height = 1400;

                // create the image
                Rectangle rect = new Rectangle(0, 0, (int) page.getBBox().getWidth(), (int) page.getBBox().getHeight());
                BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                // width & height, // clip rect, // null for the ImageObserver, // fill background with white, // block until drawing is done
                Image image = page.getImage(width, height, rect, null, true, true );
                Graphics2D bufImageGraphics = bufferedImage.createGraphics();
                bufImageGraphics.drawImage(image, 0, 0, null);

                File imageFile = new File( destinationDir + fileName +"_"+ pageNumber +".png" );// change file format here. Ex: .png, .jpg, .jpeg, .gif, .bmp

                ImageIO.write(bufferedImage, "png", imageFile);
                pageNumber++;

                System.out.println(imageFile.getName() +" File created in Folder: "+ destinationFile.getCanonicalPath());
            }
        } else {
            System.err.println(sourceFile.getName() +" File not exists");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}