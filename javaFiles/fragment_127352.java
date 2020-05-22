import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Counter extends Application {

    private final int saveSpeedInt = 60 ;

    @Override
    public void start(Stage primaryStage) {
        ProgressBar pbar = new ProgressBar();
        Label label = new Label();

        Button start = new Button("Start");

        start.setOnAction(e -> {
            Task<?> task = taskCreator(saveSpeedInt);
            pbar.progressProperty().bind(task.progressProperty());

            new Thread(task).start();

            label.textProperty().bind(
                    task.progressProperty()
                    .multiply(-1)
                    .add(1)
                    .multiply(saveSpeedInt)
                    .asString("Seconds remaining: %.0f"));

//          label.textProperty().bind(Bindings.createStringBinding(() ->
//              String.format("Seconds remaining:  %.0f", saveSpeedInt * (1 - task.getProgress())),
//              task.progressProperty()));
        });

        VBox root = new VBox(10, start, label, pbar);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 350, 120);
        primaryStage.setScene(scene);
        primaryStage.show();





    }

    private Task<Void> taskCreator(int seconds) {
        return new Task<Void>() {

            @Override
            protected Void call() throws Exception {

                updateProgress(0, seconds);

                for (int i = 0; i < seconds; i++) {
                    Thread.sleep(1000);
                    updateProgress(i + 1, seconds);

                }
                return null;
            }
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}