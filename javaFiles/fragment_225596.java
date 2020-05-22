import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {
    private static final Logger TRACE_LOGGER = LogManager.getLogger("TRACE");
    private static final Logger DEBUG_LOGGER = LogManager.getLogger("DEBUG");
    private static final Logger INFO_LOGGER = LogManager.getLogger("INFO");
    private static final Logger WARN_LOGGER = LogManager.getLogger("WARN");
    private static final Logger ERROR_LOGGER = LogManager.getLogger("ERROR");
    private static final Logger FATAL_LOGGER = LogManager.getLogger("FATAL");

    public static void trace(Object msg){
        TRACE_LOGGER.trace(msg);
    }

    public static void debug(Object msg){
        DEBUG_LOGGER.debug(msg);
    }

    public static void info(Object msg) {
        INFO_LOGGER.info(msg);
    }

    public static void warn(Object msg){
        WARN_LOGGER.warn(msg);
    }

    public static void error(Object msg) {
        ERROR_LOGGER.error(msg);
    }

    public static void fatal(Object msg){
        FATAL_LOGGER.fatal(msg);
    }
    ...
}