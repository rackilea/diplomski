import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class TestFileProcessing {

    public static void main(String[] argv) {

        try {
            long time = System.currentTimeMillis();
            File from = new File("C:\\Test\\Input.txt");
            createTestFile(from, StandardCharsets.UTF_8, 1_000_000_000);
            System.out.println("Created file in: " + (System.currentTimeMillis() - time) + "ms");

            time = System.currentTimeMillis();
            File to = new File("C:\\Test\\Output.txt");
            doIt(from, to, StandardCharsets.UTF_8);
            System.out.println("Converted file in: " + (System.currentTimeMillis() - time) + "ms");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static void createTestFile(File file, Charset encoding, long size) throws IOException {
        Random r = new Random(12345);
        try (OutputStream fout = new FileOutputStream(file);
                BufferedOutputStream bout = new BufferedOutputStream(fout);
                Writer writer = new OutputStreamWriter(bout, encoding)) {
            for (long i=0; i<size; ++i) {
                int c = r.nextInt(26);
                if (c == 0)
                    writer.write('}');
                else
                    writer.write('a' + c);
            }
        }
    }

    public static void doIt(File from, File to, Charset encoding) throws IOException {
        try (InputStream fin = new FileInputStream(from);
                BufferedInputStream bin = new BufferedInputStream(fin);
                Reader reader = new InputStreamReader(bin, encoding);
                OutputStream fout = new FileOutputStream(to);
                BufferedOutputStream bout = new BufferedOutputStream(fout);
                Writer writer = new OutputStreamWriter(bout, encoding)) {
            int c;
            while ((c = reader.read()) >= 0) {
                if (c == '}')
                    writer.write('\n');
                writer.write(c);
            }
        }
    }

}