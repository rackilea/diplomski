import java.awt.GraphicsEnvironment;
import java.util.Map;
import java.util.Properties;

public class Sof39189179 {

    public static void main(String[] args) {

        Map<String, String> sysenv = System.getenv();

        for(String key: sysenv.keySet())
            System.out.println( key +  ": " + sysenv.get(key));

        Properties properties = System.getProperties();

        for(Object key: properties.keySet())
            System.out.println(key + ": " + properties.get(key));

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
        System.out.println("headless: " + ge.isHeadless());
    }
}