class MetricsUpdater {

    private static volatile MetricsUpdater theInstance;
    public volatile String myValue;

    /**
     * DCL . Please avoid
     * Better use 
     * private static MetricsUpdater theInstance = new MetricsUpdate();
     */
    public static MetricsUpdater getInstance() {
        if (theInstance == null) {
            synchronized(MetricsUpdate.class) {
                 if(theInstance == null) {
                     theInstance = new MetricsUpdater();
                 }
            }
        }
        return theInstance;
    }

    // this runs on a timer but to keep it simple I'll just define the method...
    // if your someMethodToUpdateMyValue is thread safe
    private void updateMetrics() {
            myValue = someMethodToUpdateMyValue();
    }
}