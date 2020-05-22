static {
    PatternLayout layout = new PatternLayout();
    String conversionPattern = "%d %-5p [%t] %c{2} (%2F:%M(%L)):%m%n";
    layout.setConversionPattern(conversionPattern);

    ConsoleAppender consoleAppender = new ConsoleAppender();
    consoleAppender.setLayout(layout);
    consoleAppender.activateOptions();

    Logger rootLogger = Logger.getRootLogger();
    rootLogger.setLevel(Level.INFO);
    rootLogger.addAppender(consoleAppender);
}