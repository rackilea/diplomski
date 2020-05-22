try {
    FileHandler handler = new FileHandler("myLogFile.log", true);
    Logger logger = Logger.getLogger(LoggingException.class.getName());
    logger.addHandler(handler);
} catch (IOException e) {
    logger.log(Level.SEVERE, "Error parsing date", e);
}