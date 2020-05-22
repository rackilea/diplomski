import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log the currently running test.
 * 
 * <p>Typical usage:
 * 
 * <p>{@code @Rule public LogTestName logTestName = new LogTestName();}
 *
 * <p>See also:
 * <br>{@link org.junit.Rule}
 * <br>{@link org.junit.rules.TestWatcher}
 */
public class LogTestName extends TestWatcher {

    private final static Logger log = LoggerFactory.getLogger( "junit.logTestName" );

    @Override
    protected void starting( Description description ) {
        log.debug( "Test {}", description.getMethodName() );
    }

}