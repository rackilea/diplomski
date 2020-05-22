public static class Sandbox {
    public static interface EventArgs {}
    public static abstract class EventHandler<E extends EventArgs> { 
        public abstract void HandleEvent(Object sender, E e);
    }
    public static class Observers<E extends EventArgs> {

        private CopyOnWriteArrayList<EventHandler<? super E>> mListeners
                = new CopyOnWriteArrayList<EventHandler<? super E>>();

        public void dispatchEvent(Object sender, E args) {
            if (mListeners != null) {
                for (EventHandler<? super E> listener : mListeners) {
                    listener.HandleEvent(sender, args);
                }
            }
        }
        public void addListener(EventHandler<? super E> listener) {
            mListeners.add(listener);
        }        
    }
}