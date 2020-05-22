private boolean initialized = false;

public synchronized boolean init() {
    if (!initialized) {
         // allocate resources, call abstract method(s)
         initialized = true;
    }
    return initialized;
}

public synchronized void cleanup() {
    if (initialized) {
         // free resources, call abstract method(s)
         initialized = false;
    }
}