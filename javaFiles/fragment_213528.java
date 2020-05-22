import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Date;
import java.util.concurrent.Executors;

public class LogThing extends Application {

private TextField textField;
private TextField textField2;
private Button clickMeBtn;

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Logger!");
    textField = new TextField();
    textField2 = new TextField();
    clickMeBtn = new Button("Click me for time");
    clickMeBtn.setOnAction(e -> {
                textField2.setText(new Date().toString());
            });
    StackPane root = new StackPane();
    VBox vBox = new VBox();
    vBox.getChildren().addAll(textField2, clickMeBtn, textField);
    root.getChildren().add(vBox);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
    Executors.newSingleThreadExecutor().submit(new BackGroundTask(this));
}

public void logALine(String line) {
    textField.setText(line);
}

class BackGroundTask implements Runnable {

    private final LogThing logThing;
    private int i = 1;

    public backGroundTask(LogThing logThing) {
        this.logThing = logThing;
    }

    @Override
    public void run() {
        while (true) {
            for (i = 1; i < 1000; i++) {
                try {
                    Thread.sleep(1000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            logThing.logALine("i : " + i);
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}