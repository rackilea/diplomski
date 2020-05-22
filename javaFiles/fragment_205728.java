import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SomeClass {

    private static Logger userLog = LogManager.getLogger("user");
    private static Logger systemLog = LogManager.getLogger("system");

    public static void main(String[] args){

        systemLog.debug("This is the top of main method");
        if(userLog.isDebugEnabled())
            userLog.debug("This is some debug!");
        userLog.info("Here's some info!");
        userLog.error("Some error happened!");
        systemLog.info("This is the end of main method");
        systemLog.error("woops an error occurred");
    }
}