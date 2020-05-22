import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

class URLExists
{   
    public static void main(String[] args)
    {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection urlc = url.openConnection();
            urlc.connect();//<--- throws UnknownHostException when unable to connect!!
            System.out.println("URL exists");           
        }
        catch(UnknownHostException e)
        {
            System.out.println("URL either doesn't exist or unable to connect at this moment");
        }
        catch(Exception e) {e.printStackTrace();}
    }
}