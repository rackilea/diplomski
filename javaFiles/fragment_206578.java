/**
 * Loops over a map of lists, adding and removing elements rapidly
 * in order to cause GC, for runFor seconds, or until the thread is
 * terminated.
 */
@Override
public void run() {
    HashMap<String,ArrayList<String>> map = new HashMap<>();

    long stop = System.currentTimeMillis() + 1000l * runFor;
    while(runFor == 0 || System.currentTimeMillis() < stop) {
        churn(map);
    }
}

/**
 * Three steps to churn the garbage collector:
 *   1. Remove churn% of keys from the map
 *   2. Remove churn% of strings from the lists in the map
 *      Fill lists back up to size
 *   3. Fill map back up to size
 * @param map
 */
protected void churn(Map<String,ArrayList<String>> map) {
    removeKeys(map);
    churnValues(map);
    addKeys(map);
}