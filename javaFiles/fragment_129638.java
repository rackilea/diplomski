import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class OnDebugOnly extends Filter {

    static boolean debug;

    @Override
    public int decide(LoggingEvent event) {
        return ( debug ? Filter.NEUTRAL : Filter.DENY ) ;
    }
}