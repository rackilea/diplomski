private ArrayMap<String,RequestData> handlers = new ArrayMap<>();

public void removeAllHandlers() {
        synchronized (handlers) {
                handlers.clear();
        }
    }