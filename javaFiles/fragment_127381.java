private static final Logger LOGGER = Logger.getLogger(CLI.class.getName());
private static final Handler CONSOLE_HANDLER = new ConsoleHandler();

static {
    LOGGER.setLevel(Level.ALL);
    LOGGER.setUseParentHandlers(false); //Don't report to the root console handler.

    CONSOLE_HANDLER.setLevel(Level.ALL);
    LOGGER.addHandler(CONSOLE_HANDLER);
}

public static void main(String[] args) {
    LOGGER.fine("test");
}