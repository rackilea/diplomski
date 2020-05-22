class Singleton {
    static Singleton getInstance() {...}
    void addListener(Listener listener) {...}
    void removeListener(Listener listener) {...}
}

class NotLeaky {
    private NotLeakyListener listener;
    NotLeaky() {
        // If the singleton changes the widget we need to know so register a listener
        Singleton singleton = Singleton.getInstance();
        listener = new NotLeakyListener(this, singleton);
        singleton.addListener(listener);
    }
    void doSomething() {...}
    protected void finalize() {
        try {
            if (listener != null)
                listener.dispose();
        } finally {
            super.finalize();
        }
    }

    private static class NotLeakyListener implements Listener {
        private WeakReference<NotLeaky> ownerRef;
        private Singleton eventer;
        NotLeakyListener(NotLeaky owner, Singleton e) {
            ownerRef = new WeakReference<NotLeaky>(owner);
            eventer = e;
        }

        void dispose() {
            if (eventer != null) {
                eventer.removeListener(this);
                eventer = null;
            }
        }

        void handleEvent() {
            NotLeaky owner = ownerRef.get();
            if (owner == null) {
                dispose();
            } else {
                owner.doSomething();
            }
        }
    }
}

// Elsewhere
while (1) {
    NotLeaky notleaky = new NotLeaky();
    // ... do stuff
    // notleaky falls out of scope
}