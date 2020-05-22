import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CustomConfig 
{
    public static Properties prop = new Properties();

    public void saveProp(String title, boolean value)
    {
        try
        {
            prop.setProperty(title,String.valueOf(value));
            prop.store(new FileOutputStream("config.radiobutton"),"");
        }
        catch(IOException e)
        {
        }
    }
    public static boolean getProp(String title) // Modified from Original
    {


        String value = title;
        try
        {
            prop.load(new FileInputStream("config.radiobutton"));
           value = prop.getProperty(title);
        }
        catch(IOException e)
        {
        }
      return Boolean.parseBoolean(value); // Modified from Original
    }

}