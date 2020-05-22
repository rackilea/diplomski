public BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
public void loop() {
    while (true) {
        Runnable currentTask = queue.take(); // blocks until something happens
        currentTask.run();
        // repeat.
    }
}
public void enqueue(Runnable runnable) {
    queue.put(runnable);
}

public static void main(String[] args) {
    startThreadsThatReceiveSystemEvents();
    enqueue(new Runnable() {
        @Override
        public void run() {
            Activity activity = createStartActivity();
            activity.onCreate();
            activity.onResume();
        }
    });
    loop(); // fun fact: an android app will never return from here
            // it's process is simply killed by the system
}