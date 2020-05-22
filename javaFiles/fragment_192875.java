import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class Main {
    static abstract class EventListener {
        public void onFileChanged() {
            throw new NotImplementedException();
        }
    }

    static class EventListenerNotImpl extends EventListener {

    }

    static class EventListenerImpl extends EventListener {
        private String id;

        public EventListenerImpl(String id) {
            this.id = id;
        }

        public void onFileChanged() {
            System.out.println(id + ":" + EventListenerImpl.class.getCanonicalName() + ".onFileChanged() was called");
        }
    }

    static class EventHandler {
        private List<EventListener> listeners = new ArrayList<>();

        public void addListener(EventListener listener) {
            listeners.add(listener);
        }

        private void propagateOnFileChangedEvent() {
            listeners.forEach(l -> {
                try {
                    Method m = l.getClass().getMethod("onFileChanged");
                    if (!m.getDeclaringClass().equals(EventListener.class)) {
                        l.onFileChanged();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) {
        EventHandler handler = new EventHandler();

        handler.addListener(new EventListenerImpl("listener-1"));
        handler.addListener(new EventListenerNotImpl()); // Not will be invoked onFileChangedEvent
        handler.addListener(new EventListenerImpl("listener-3"));

        handler.propagateOnFileChangedEvent();
    }
}