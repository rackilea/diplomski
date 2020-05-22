public class Logger {
    private static final Logger INSTANCE = new Logger();

    private Logger() {
        // do something to initialize the logger
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    // implementation ...
}