package mypackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test {

    public static void main(String args[]) throws Exception {
        File file = new File("/test.txt");
        for (int i = 0; i < 1000; i++) {
            write("line" + i, file); // Write "many" lines.
        }
        System.out.println("File exist before delete? " + file.exists());
        System.out.println("File deleted? " + file.delete());
        System.out.println("File exist after delete? " + file.exists());
    }

    public static void write(String line, File file) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            writer.write(line);
        } finally {
            if (writer != null) try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Close failed!");
                e.printStackTrace();
            }
        }
    }
}