package q10025482;

import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        String fileName = "C:/System Volume Information";//"C:/pagefile.sys"
        File file = new File(fileName);
        System.out.println("\nFile " + file.getAbsolutePath() + " info:");
        System.out.println("Exists: " + file.exists());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is dir: " + file.isDirectory());
        System.out.println("Length: " + file.length());
        System.out.println();
    }
}