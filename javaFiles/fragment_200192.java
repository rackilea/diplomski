System.out.println(Run.class.getName());
    Logger logger = Logger.getLogger(Run.class.getName());
    logger.setLevel(logLevel.isEmpty() ? defaultLevel : Level.parse(logLevel));

    Handler consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(logLevel.isEmpty() ? defaultLevel : Level.parse(logLevel));
    logger.addHandler(consoleHandler);

    logger.setUseParentHandlers(false);