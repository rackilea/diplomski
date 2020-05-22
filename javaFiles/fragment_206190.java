import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamer {

    public void streamZip(OutputStream os, Iterable<FileLink> entries) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(os);
        for(FileLink e: entries) {

            ZipEntry entry = new ZipEntry(e.getName());
            File file = e.getFile();
            entry.setTime(file.lastModified());
            zos.putNextEntry(entry);
            if (file.isFile()) {
                copyBytes(zos, new FileInputStream(file));
            }
            zos.closeEntry();
        }
        zos.close();
    }

    private static void copyBytes(OutputStream dest, InputStream source) {
        // copy data between streams
    }

    public interface FileLink {

        public String getName();

        public File getFile();
    }
}