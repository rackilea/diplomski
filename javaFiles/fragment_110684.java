public class WatchDir {

    // Executor for notifications: by default just run on the current thread
    private Executor notificationExecutor = Runnable::run ;
    public void setNotificationExecutor(Executor notificationExecutor) {
        this.notificationExecutor = notificationExecutor ;
    }

    private Consumer<Path> onCreate ;
    // etc...

    void processEvents() {

        // ...

        if (! recursive && kind == ENTRY_CREATE) {
            if (onCreate != null) {
                notificationExecutor.execute(() -> onCreate.accept(child));
            }
        }

        // ...
    }

}