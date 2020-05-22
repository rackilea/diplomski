class ClientCache {
    ...
    public void process(ArrayList<Integer> bulk) {
        // synchronise cache manipulation
        synchronized(getSynchronizationObject()) {
            // merge howsoever you like...
            getCache().addAll(bulk);
        }
    }
}