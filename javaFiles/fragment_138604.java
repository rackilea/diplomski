public class GamePan extends JPanel {
    private final List<MyEventListener> myEventListeners = new LinkedList<>();

    // Here, keep everything you already have

    public void addMyEventListener(final MyEventListener listener) {
        this.myEventListeners.add(listener);
    }

    private void notifyWordFound(/* any data you could use */) {
        for(final MyEventListener listener : this.myEventListeners) {
            listener.wordFound(/* any data you could use */)
        }
    }
}