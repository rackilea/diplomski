import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public final class FileDownloader {

    private FileDownloader(){}

    public static void main(String args[]) throws IOException{
        download("http://pdfobject.com/pdf/sample.pdf", new File("sample.pdf"));
    }

    public static void download(final String url, final File destination) throws IOException {
        final URLConnection connection = new URL(url).openConnection();
        connection.setConnectTimeout(60000);
        connection.setReadTimeout(60000);
        connection.addRequestProperty("User-Agent", "Mozilla/5.0");
        final FileOutputStream output = new FileOutputStream(destination, false);
        final byte[] buffer = new byte[2048];
        int read;
        final InputStream input = connection.getInputStream();
        while((read = input.read(buffer)) > -1)
            output.write(buffer, 0, read);
        output.flush();
        output.close();
        input.close();
    }
}