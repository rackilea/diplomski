private static final Logger log = Logger.getLogger("ProfileStatusClass");
static {
    log.setLevel(Level.ALL);
    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(new MyFormatter());
    handler.setLevel(Level.ALL);
    log.addHandler(handler);
}