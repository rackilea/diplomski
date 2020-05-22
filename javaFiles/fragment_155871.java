import java.io.*;
import java.nio.charset.*;

public class Test {

    private static Charset UTF8 = Charset.forName("UTF-8");

    public static void main(String args[]) throws IOException {
        writeFile("./test.txt");
        readFile("./test.txt");
    }

    public static void writeFile(String path) throws IOException {
        Writer writer = new OutputStreamWriter(new FileOutputStream(path), UTF8);
        try {
            writer.write((char) 147);
        } finally {
            writer.close();
        }
    }

    public static void readFile(String path) throws IOException {
        Reader reader = new InputStreamReader(new FileInputStream(path), UTF8);
        try {
            int c = reader.read();
            System.out.println(c);
        } finally {
            reader.close();
        }
    }
}