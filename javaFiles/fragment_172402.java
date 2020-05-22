try(InputStream configFile = getClass().getClassLoader().getResourceAsStream("logging.properties")) {
    LogManager.getLogManager().readConfiguration(configFile);
} catch (IOException e) {
    throw new IllegalStateException("Unable to load default logging properties.", e);
}

Level lvl;
if (isDebugEnabled()) {
    lvl = Level.FINEST;
} else {
    lvl = Level.INFO;
}
logger.setLevel(lvl);
for(Handler h : logger.getHandlers()) {
    h.setLevel(lvl);
}