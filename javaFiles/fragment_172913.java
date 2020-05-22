// accessed only from the EDT
private List<MyPortListener> portListeners = new ArrayList<MyPortListener>();

public void addMyPortListener(MyPortListener listener) {
    portListeners.add(listener);
}

public void removeMyPortListener(MyPortListener listener) {
    portListeners.remove(listener);
}

... 

    @Override
    public void serialEvent(SerialPortEvent spe) {
        ...
        final String receivedString = ...;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (MyPortListener listener : portListeners) {
                    listener.stringReveivedFromSerialPort(receivedString);
                }
            }
        });
    }