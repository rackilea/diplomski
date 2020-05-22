public interface BackgroundProcessingLock {

    void allowBackgroundTasks();

    void preventBackgroundsTasks(boolean wait);  

    void wait();  // simply waits until all background tasks complete

    void startBackgroundTask();

    void completeBackgroundTask();

    void setMaxNumberOfBackgroundTasks(int maxParallelBackgroundTasks);

}