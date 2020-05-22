import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hello{

public static void main(String []args){

try
{
        URL url = new URL("http://stackoverflow.com");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
        for (String line; (line = reader.readLine()) != null;) {
            System.out.println(line);
            }
        }
}
catch (Exception e)
    {
            System.out.println("error occured");
    }
    }
}