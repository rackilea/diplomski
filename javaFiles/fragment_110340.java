package fr.telecomParisTech;
import java.io.File;
import javaFlacEncoder.FLAC_FileEncoder;
public class SoundConverter {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FLAC_FileEncoder flacEncoder = new FLAC_FileEncoder();
        File inputFile = new File("hello.wav");
        File outputFile = new File("hello.flac");

        flacEncoder.encode(inputFile, outputFile);
        System.out.println("Done");
    }
}