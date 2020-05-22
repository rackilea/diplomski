import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

import java.io.OutputStream;
import java.io.FileOutputStream;

class Foo {
    private static void copyStream(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[64*1024];
        int length;
        while ((length = input.read(buffer)) != -1) {
            output.write(buffer,0,length);
        }
    }

    private static void copyFile(String inputPath, String outputPath) throws IOException {
        try (
            FileInputStream input = new FileInputStream(inputPath);
            FileOutputStream output = new FileOutputStream(outputPath)
        ) {
            copyStream(input, output);
        }
    }

    public static void main(String[] args) throws IOException {
        copyFile(args[0], args[1]);
    }
}