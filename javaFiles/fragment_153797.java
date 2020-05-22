package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String name = "/tmp/test";
        GZIPOutputStream gz = new GZIPOutputStream(new FileOutputStream(name));
        gz.write(10);
        gz.close();
        System.out.println(new GZIPInputStream(new FileInputStream(name)).read());
    }
}