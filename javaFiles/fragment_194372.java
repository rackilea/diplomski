import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);

            Pane pane = new Pane();
            Text text = new Text("");
            pane.getChildren().add(text);
            Task<Void> task = new Task<Void>() {
                String a = "Initial text";

                @Override
                public Void call() throws Exception {
                    int i = 0;

                    while (true) {

                        if (i > 4)
                            a = "I is bigger than 4";

                        if (i > 10)
                            a = "I is bigger than 10";

                        Platform.runLater(() -> {
                            text.setText(a);
                            // If you want to you can also move the text here
                            text.relocate(10, 10);
                        });

                        i++;
                        Thread.sleep(1000);
                    }
                }
            };
            Thread th = new Thread(task);
            th.setDaemon(true);
            th.start();

            root.setCenter(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}