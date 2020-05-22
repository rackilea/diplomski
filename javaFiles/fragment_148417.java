private static final Logger log = Logger.getLogger(ServerThread.class.getName());
private static final FileHandler fh;
static {
    try {
        log.setUseParentHandlers(false);
        fh = new FileHandler("ex.txt", true);
        fh.setFormatter(new SimpleFormatter());
        fh.setLevel(Level.FINE);
        log.addHandler(fh);
        log.setLevel(Level.FINE);
    } catch (IOException ioe) {
        throw new ExceptionInInitializerError(ioe);
    }
}