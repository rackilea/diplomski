import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UncaughtExceptionTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        // start is called on the FX Application Thread, 
        // so Thread.currentThread() is the FX application thread:
        Thread.currentThread().setUncaughtExceptionHandler((thread, throwable) -> {
            System.out.println("Handler caught exception: "+throwable.getMessage());
        });

        StackPane root = new StackPane();
        Button button = new Button("Throw exception");
        button.setOnAction(event -> {
            throw new RuntimeException("Boom!") ;
        });
        root.getChildren().add(button);
        Scene scene = new Scene(root, 150, 60);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}