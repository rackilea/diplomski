public class FXUtils {

    public static void runAndWait(Runnable run) throws InterruptedException {
        FutureTask<Void> task = new FutureTask<>(run, null);
        Platform.runLater(task);
        task.get();
    }
}