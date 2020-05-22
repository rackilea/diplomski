Logger topLogger = Logger.getLogger("");

    Handler consoleHandler = null;
    for (Handler handler : topLogger.getHandlers()) {
        if (handler instanceof ConsoleHandler) {
            //found the console handler
            consoleHandler = handler;
            break;
        }
    }

    if (consoleHandler == null) {
        // not found, create a new one
        consoleHandler = new ConsoleHandler();
        topLogger.addHandler(consoleHandler);
    }
    //set the console handler level
    consoleHandler.setLevel(logLevel.isEmpty() ? defaultLevel : Level.parse(logLevel));