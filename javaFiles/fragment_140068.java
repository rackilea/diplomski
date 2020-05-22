import javafx.application.Application;
import javafx.stage.Stage;

public class ThreadDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        int count = Thread.activeCount();
        System.out.println("currently active threads = " + count);

        Thread th[] = new Thread[count];
        // returns the number of threads put into the array
        Thread.enumerate(th);

        // set the priority
        for (int i = 0; i < count; i++) {
            // Priority 0 is not allowed
            th[i].setPriority(i + 1);
            System.out.println(i + ": " + th[i] + " has priority of "
                    + th[i].getPriority());
        }

        // To check if change in priority is reflected
        System.out.println("Current Thread " + Thread.currentThread().getName()
                + " priority " + Thread.currentThread().getPriority());
    }
}