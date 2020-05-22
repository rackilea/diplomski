import io.mola.galimatias.GalimatiasParseException;
import io.mola.galimatias.URL;

import java.net.URI;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        String example1 = "http://example.com/foo?key=val-with-a-|-in-it";
        String example2 = "http://example.com?foo={bar}";

        try {
            URL url1 = URL.parse(example1);
            URI uri1 = url1.toJavaURI();
            System.out.println(url1);
            System.out.println(uri1);

            URL url2 = URL.parse(example2);
            URI uri2 = url2.toJavaURI();
            System.out.println(url2);
            System.out.println(uri2);
        } catch (GalimatiasParseException ex) {
            // Do something with non-recoverable parsing error
        }
    }
}