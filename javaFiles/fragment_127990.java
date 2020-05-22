class MyClass {
    Logger fileLogger = Logger.getLogger("something.mapped.to.file");
    Logger dbLogger = Logger.getLogger("something.mapped.to.db");

    public void someMethod() {
        dbLogger.log("XXX");
        fileLogger.log("YYY");
    }
}