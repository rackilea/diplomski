import java.util.logging.Level;

    .
    .
    .
    LOG.setLevel(Level.ALL);

    LOG.warning("Warning message logged");
    LOG.severe("severe debug message logged");
    LOG.info("info message logged");
    LOG.config("config message logged");
    LOG.fine("some fine message");
    LOG.finer("some finer message");
    LOG.finest("some finest message");