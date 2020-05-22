import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String args[]) throws MalformedURLException, IOException{
        BufferedInputStream in = new BufferedInputStream(new URL("https://a.uguu.se/wiaXcKwue2DH_cass").openStream());
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        System.out.println(result.toString("UTF-8"));
    }
}