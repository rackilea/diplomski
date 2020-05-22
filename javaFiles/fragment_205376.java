public class MyCache {

    private final static HashMap cacheMap = new HashMap();  // One Map for all
    private final static Vector fetchList = new Vector();   // One List for all

    private Object cacheValue;
    private boolean waitingState;

    public MyCache (Object key) {
        if (cacheMap.containsKey (key)) {       // somebody has done it
            cacheValue = cacheMap.get (key);
        } else {
            waitingState = true;
            if (fetchInProgress (key, false))   // someone else is doing it
                return;
            new Thread (new MyFetch (key)).start();
    }}

    synchronized private static boolean fetchInProgress (Object key, boolean remove) {
        if (remove) {
            fetchList.remove (key);
        } else {
            boolean fetchingNow = fetchList.contains (key);
            if (fetchingNow)
                return true;
            fetchList.addElement (key);
        }
        return false;
    }

    public Object getValue () {
        if (waitingState)
            getCacheValue (true);
        return cacheValue;
    }

    synchronized private void getCacheValue (boolean waitOnLock) {
        if (waitOnLock) {
            while (waitingState) {
                try {
                    wait();
                } catch (InterruptedException intex) {
        }}} else {
            waitingState = false;
            notifyAll();
    }}

    public class MyFetch implements Runnable {
        private Object fetchKey;
        public MyFetch (Object key) {
            fetchKey = key;     // run() needs to know what to fetch
        }

        public void run () {        // Grab the resource, handle exception, etc.
            Object fetchedValue = null; 
            // so it compiles, need to replace by callWebService (fetchKey);
            cacheMap.put (fetchKey, fetchedValue);  // Save for future use
            fetchInProgress (fetchKey, true);   // Remove from list
            getCacheValue (false);          // Notify waiting threads
}}}