public void registerListener(String type, MessageListener listener) {
    List<MessageListener> listeners = registrationMap.get(type);
    if (listeners == null) {
        listeneres = new ArrayList<MessageListener>();
        registrationMap.put(type, listeners);
    }
    listeners.add(listener);
}

public void dispatchMessage(Message msg) {
    List<MessageListener> listeners = registrationMap.get(type);
    if (listeners != null) {
        for(MessageListener listener : listeners) {
            listener.send(msg);
        }
    }
}