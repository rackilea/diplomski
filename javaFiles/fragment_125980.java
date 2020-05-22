import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyPropWithinClasspath {

    private Properties prop = null;

    public MyPropWithinClasspath(){

        InputStream is = null;
        try {
            this.prop = new Properties();
            is = this.getClass().getResourceAsStream("/sample.properties");
            prop.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String key){
        return this.prop.getProperty(key);
    }

    public static void main(String a[]){

        MyPropWithinClasspath mpc = new MyPropWithinClasspath();
        System.out.println("db.host: "+mpc.getPropertyValue("db.host"));
        System.out.println("db.user: "+mpc.getPropertyValue("db.user"));
        System.out.println("db.password: "+mpc.getPropertyValue("db.password"));
    }
}