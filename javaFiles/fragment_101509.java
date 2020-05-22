import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djc39_000
 */
public class URLBrowser {

    public static void main(String[] args) {
        try {            
            URLConnection uc =  new URL("https://www.google.com").openConnection(
                    new Proxy(Proxy.Type.HTTP, new InetSocketAddress("my.proxy.example.com", 3128))
            );
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String line;            
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLBrowser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(URLBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}