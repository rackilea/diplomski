import java.io.*;
import java.util.zip.*;
import org.apache.commons.io.IOUtils; // <-- get this from http://commons.apache.org/io/index.html

public class CompressionTest2 {

    public static void main(String[] args) throws IOException {
        File input = new File("input.txt");
        File output = new File("output.bin");
        Compression.compress(input, output);
        File input2 = new File("input2.txt");
        Compression.decompress(output, input2);
        // At this point, input.txt and input2.txt should be equal
    }

}

class Compression {

    public static void compress(File input, File output) throws IOException {
        FileInputStream fis = new FileInputStream(input);
        FileOutputStream fos = new FileOutputStream(output);
        GZIPOutputStream gzipStream = new GZIPOutputStream(fos);
        IOUtils.copy(fis, gzipStream);
        gzipStream.close();
        fis.close();
        fos.close();
    }

    public static void decompress(File input, File output) throws IOException {
        FileInputStream fis = new FileInputStream(input);
        FileOutputStream fos = new FileOutputStream(output);
        GZIPInputStream gzipStream = new GZIPInputStream(fis);
        IOUtils.copy(gzipStream, fos);
        gzipStream.close();
        fis.close();
        fos.close();
    }

}