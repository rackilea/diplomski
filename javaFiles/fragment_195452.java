interface Listener {
    void log(String log);
}

enum Logger {

    instance;

    private List<Listener> listeners = new LinkedList<Listener>();

    public void addListener(Listener l) {
    synchronized(listeners) {
        listeners.add(l);
     }
    }

    public void log(String log) {
        synchronized(listeners) {
            for(Listener l : listeners)
                l.log(log);
        }
    }
}