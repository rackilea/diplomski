import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
public class Logs {

    public static Logger Application_Log = Logger.getLogger(Logs.class.getName());

    public Logs(){
         DOMConfigurator.configure("log4j-config.xml");
    }
public void info(String message){
        Application_Log.info(message);
    }