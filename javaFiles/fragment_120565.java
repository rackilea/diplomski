import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MapMessage;

public class MapMessageExample {

    private static final Logger log = LogManager.getLogger();   

    public static void main(String[] args){
        log.info(buildMsg("My title", "This is the description", 
                "No response needed", "Some details here"));        
    }

    // This could be moved into a factory class
    public static MapMessage buildMsg(String title, String description, 
            String responseAction, String details)
    {
        MapMessage mapMsg = new MapMessage();
        mapMsg.put("title", title);
        mapMsg.put("desc", description);
        mapMsg.put("response", responseAction);
        mapMsg.put("details", details);
        return mapMsg;
    }
}