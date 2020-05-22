public static MetricsUpdater getInstance() {
        if (theInstance == null) {
            theInstance = new MetricsUpdater();
        }
        return theInstance;
    }