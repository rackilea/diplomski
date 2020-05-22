package william;
import java.util.logging.Logger;

public final class Main{
    private Main(){}
    public static void main(final String [ ] args){
        final Logger log = Logger.getLogger(Main.class.getName());
        log.fine("Hello World");
    }
}