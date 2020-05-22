class TrafficController {
    private static Set<TrafficListener> listeners = new HashSet<>();

    public static void controlTraffic() {
        // do stuff
        notifyListeners();
    }

    public static void addTrafficListener(TrafficListener listener) {
        listeners.add(listener);
    }

    public static void removeTrafficListener(TrafficListener listener) {
        listeners.remove(listener);
    }

    private static void notifyListeners() {
        for (TrafficListener listener : listeners) {
            listener.watchNewTraffic();
        }
    }
}