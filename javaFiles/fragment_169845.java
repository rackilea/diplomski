void run() {
    String dataId = data.getId();
    boolean workDone = true;
    synchronized (statusSet) {
        if (!statusSet.contains(dataId)) {
            workDone = false;
            statusSet.add(dataId);
        }
    }                 

    if (!workDone) {
        // ... work with the data
    }
}