public SunToolkit() {
    Runnable initEQ = new Runnable() {
        public void run() {
            EventQueue eventQueue;

            String eqName = System.getProperty("AWT.EventQueueClass", "java.awt.EventQueue");

            try {
                eventQueue = (EventQueue) Class.forName(eqName).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Failed loading " + eqName + ": " + e);
                eventQueue = new EventQueue();
            }
            AppContext appContext = AppContext.getAppContext();
            appContext.put(AppContext.EVENT_QUEUE_KEY, eventQueue); //queue added here

            PostEventQueue postEventQueue = new PostEventQueue(eventQueue);
            appContext.put(POST_EVENT_QUEUE_KEY, postEventQueue);
        }
    };

    initEQ.run();
}