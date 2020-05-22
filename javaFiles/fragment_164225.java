import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class ChangeToXml {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties p = new Properties();
        //load from your original file;
        FileInputStream inputProps = new FileInputStream("C:\\tmp\\config.properties");
        p.load(inputProps);
        //store in xml format
        FileOutputStream outputXml = new FileOutputStream("C:\\tmp\\properties.xml");
        p.storeToXML(outputXml, "Properties Example");
        //load from xml
        FileInputStream inputXml = new FileInputStream("C:\\tmp\\properties.xml");
        p.loadFromXML(inputXml);
        // get key value pair in the same way as from your original file
        String browser = p.getProperty("browser");
        String url = p.getProperty("url");

        System.out.println("browser: " + browser);
        System.out.println("url: " + url);
    }
}