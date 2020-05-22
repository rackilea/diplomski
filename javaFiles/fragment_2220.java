//Use enum to have singleton provided by jvm
enum DataCache {

    INSTANCE;

    //Use LinkedList if you expecting many calls. The insertion will be much faster.
    private List<String> data = new LinkedList<>();

    synchronized void add(String value) {
        data.add(value);
    }

    /*
     * Returns defensive copy, so that no one has reference to this.data.
     * If data is fetched only on clear you can make this private instead of synchronized 
     * (or even better get rid of it and create defensive copy inside clear()).
     */
    synchronized List<String> get() {
        return new ArrayList<>(data); 
    }

    /*
     * Returns last snapshot of data to keep consistency.
     */
    synchronized List<String> clear() {
        List<String> lastSnapshot = get();
        data = new LinkedList<>();
        return lastSnapshot;
    }
}