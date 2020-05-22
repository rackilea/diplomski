import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ServiceRestartTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Service<Void> s = new Service<Void>(){
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>(){
                    @Override
                    protected Void call() throws Exception {
                        //DOWNLOAD DATA
                        System.out.println("New task on thread "+Thread.currentThread());
                        System.out.println("1");
                        Thread.sleep(1000);
                        System.out.println("2");
                        Thread.sleep(1000);
                        System.out.println("3");
                        Thread.sleep(1000);
                        return null;
                    }
                };
            }
        };
        s.setExecutor(Executors.newCachedThreadPool(runnable -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t;
        }));

        s.stateProperty().addListener((obs, oldState, newState) -> System.out.println(newState));

        TextField textField = new TextField();
        textField.setOnKeyReleased(e -> s.restart());

        primaryStage.setScene(new Scene(new StackPane(textField), 350, 120));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}