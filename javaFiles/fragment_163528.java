protected EventQueue getSystemEventQueueImpl() {
    return getSystemEventQueueImplPP();
}

// Package private implementation
static EventQueue getSystemEventQueueImplPP() {
    return getSystemEventQueueImplPP(AppContext.getAppContext());
}

public static EventQueue getSystemEventQueueImplPP(AppContext appContext) {
    EventQueue theEventQueue = (EventQueue) appContext.get(AppContext.EVENT_QUEUE_KEY);
    return theEventQueue;
}