import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Snippet {

    public static void main(String[] args) throws IOException {

        InputStream w = getInputStreamForEntry(new FileInputStream("file.ear"), "file.war");
        InputStream t = getInputStreamForEntry(w, "prova.txt");

        try (Scanner s = new Scanner(t);) {
            s.useDelimiter("\\Z+");
            if (s.hasNext()) {
                System.out.println(s.next());
            }
        }

    }

    protected static InputStream getInputStreamForEntry(InputStream in, String entry)
            throws FileNotFoundException, IOException {
        ZipInputStream zis = new ZipInputStream(in);

        ZipEntry zipEntry = zis.getNextEntry();

        while (zipEntry != null) {
            if (zipEntry.toString().equals(entry)) {
                // in this line I want to get a ZipFile from the file "file.war"
                return zis;
            }
            zipEntry = zis.getNextEntry();
        }
        throw new IllegalStateException("No entry '" + entry + "' found in zip");
    }

}