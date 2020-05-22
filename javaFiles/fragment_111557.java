package stackoverflow;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.stage.Stage;

// extending Application
public class X extends Application {

    // Empty constructor. I just put it here so we know explicitly that a no-arg construcor exists.
    public X() {
        // NOP
    }

    @Override
    // a hook for starting the Applicatoin
    public void start(Stage primaryStage) {
        run();
    }

    // This is a proper entry point of a JavaFX application
    public static void main(String[] args) {
        launch(args);
    }

    private void run() {
        // creating a service, then running it
        ExampleService service = new ExampleService();
        service.start();
    }

    // this is the dummy service
    private static class ExampleService extends Service<Void> {

        @Override
        protected Task<Void> createTask() {
            Task<Void> task = new Task<Void>() {

                @Override
                protected Void call() throws Exception {
                    System.out.println("called");
                    // for Task<Void> we should return null
                    return null;
                }

                @Override
                protected void succeeded() {
                    // one hook - overriding
                    super.succeeded();
                    System.out.println("Succeded");
                }

                @Override
                protected void failed() {
                    // one hook - overriding
                    super.failed();
                    System.out.println("Failed");
                }
            };

            task.setOnSucceeded((WorkerStateEvent event) -> {
                // another hook - callback lambda
                System.out.println("In set on Succeded");
            });

            task.setOnFailed((WorkerStateEvent event) -> {
                // another hook - callback lambda
                System.out.println("In Failed");
            });
            return task;
        }

    }

}