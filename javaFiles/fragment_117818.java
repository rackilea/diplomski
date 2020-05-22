package apache.utils.custom;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
public class Downloader {

    private static final int EOF = -1;
    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;


    public static void copyInputStreamToFileNew(final InputStream source, final File destination, int fileSize) throws IOException {
        try {

            final FileOutputStream output = FileUtils.openOutputStream(destination);
            try {

                final byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
                long count = 0;
                int n = 0;
                while (EOF != (n = source.read(buffer))) {
                    output.write(buffer, 0, n);
                    count += n;
                    System.out.println("Completed " + count * 100/fileSize + "%");
                }

                output.close(); // don't swallow close Exception if copy completes normally
            } finally {
                IOUtils.closeQuietly(output);
            }

        } finally {
            IOUtils.closeQuietly(source);
        }
}