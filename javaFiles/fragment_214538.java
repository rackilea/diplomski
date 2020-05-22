package weather;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * GoogleWeather
 * @author Michael
 * @since 2/12/11
 */
public class GoogleWeather
{

    public static void main(String[] args)
    {
        for (String userZip : args)
        {
            BufferedReader br = null;
            try
            {
                String link = "http://www.google.com/ig/api?weather=" + userZip;
                System.out.println(link);
                URL googleWeatherService = new URL(link);
                br = new BufferedReader(new InputStreamReader(googleWeatherService.openStream()));
                SAXReader reader = new SAXReader();
                Document document = reader.read(googleWeatherService);
                OutputFormat format = OutputFormat.createPrettyPrint();
                XMLWriter writer = new XMLWriter(System.out, format);
                writer.write(document);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                close(br);
            }
        }
    }

    private static void close(BufferedReader br)
    {
        try
        {
            if (br != null)
            {
                br.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}