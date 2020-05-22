class MetricsUpdater {

 private static volatile MetricsUpdater theInstance;
 public volatile String myValue;

 /**
 ** Use ReentrantLock instead
 */
 private final  Object lock  = new Object();


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
private void updateMetrics() {
    synchronized(lock) {
        myValue = someMethodToUpdateMyValue();
    }
}