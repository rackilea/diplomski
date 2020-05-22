import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;

public class DownloadImage {

    public static void main(String[] args) {

        // URLs for Images we wish to download
        String[] urls = {
                "http://cdn.sstatic.net/stackoverflow/img/apple-touch-icon.png",
                "http://www.google.co.uk/images/srpr/logo3w.png",
                "http://i.microsoft.com/global/en-us/homepage/PublishingImages/sprites/microsoft_gray.png"
                };

        for(int i = 0; i < urls.length; i++) {
            downloadFromUrl(urls[i]);
        }

    }

    /*
    Extract the file name from the URL
    */
    private static String getOutputFileName(URL url) {

        String[] urlParts = url.getPath().split("/");

        return "c:/temp/" + urlParts[urlParts.length-1];
    }

    /*
    Assumes there is no Proxy server involved.
    */
    private static void downloadFromUrl(String urlString) {

        InputStream is = null;
        FileOutputStream fos = null; 

        try {
            URL url = new URL(urlString);

            System.out.println("Reading..." + url);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection(proxy);

            is = conn.getInputStream(); 

            String filename = getOutputFileName(url);

            fos = new FileOutputStream(filename);

            byte[] readData = new byte[1024];

            int i = is.read(readData);

            while(i != -1) {
                fos.write(readData, 0, i);
                i = is.read(readData);
            }

            System.out.println("Created file: " + filename);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println("Big problems if InputStream cannot be closed");
                }
            }           
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    System.out.println("Big problems if FileOutputSream cannot be closed");
                }
            }
        }

        System.out.println("Completed");
    }
}