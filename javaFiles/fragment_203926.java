public void doSomething() {
    Logger txLogger = Logger.getLogger("org.springframework.transaction");
    Level defaultLevel = txLogger.getLevel();
    txLogger.setLevel(Level.DEBUG);
    // do my stuff
    txLogger.setLevel(defaultLevel);
}