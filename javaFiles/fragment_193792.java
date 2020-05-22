import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TwoLongProcessWithOneProgressBar extends Application {

    @Override
    public void start(Stage stage) throws InterruptedException {

        BorderPane mainPane = new BorderPane();

        FlowPane topPane = new FlowPane(Orientation.HORIZONTAL, 5.,5.);
        topPane.setPadding(new Insets(20.));

        Panel panel = new Panel();
        BorderPane.setAlignment(panel, Pos.CENTER);

        Button button = new Button("Start");
        button.setDefaultButton(true);
        button.setOnAction(e -> {
            panel.runLlongTask();
            button.setDisable(true);
        });
        topPane.getChildren().add(button);
        mainPane.setTop(topPane);

        mainPane.setCenter(panel);
        mainPane.setBottom(panel.getBar());

        Scene scene = new Scene(mainPane, Color.WHITE);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Panel extends HBox{

    private final ProgressBar bar;

    Panel(){
        setPrefSize(150,50);
        bar = new ProgressBar();
        bar.prefWidthProperty().bind(widthProperty());
    }

    void runLlongTask() {
        Task task1 = new Task1();
        Thread th1 = new Thread(task1);
        th1.setDaemon(true);

        Task task2 = new Task2();
        Thread th2 = new Thread(task2);
        th2.setDaemon(true);
        //bind progress bar to both task progress property
        bar.progressProperty().bind(task1.progressProperty().add(task2.progressProperty()));
        th1.start();
        th2.start();
    }

    ProgressBar getBar() {  return bar; }
}

class Task1 extends Task<Void>{
    @Override
    protected Void call() throws Exception {
        for (int i =0; i<1000; i++) {
            TimeUnit.MILLISECONDS.sleep(100);
            updateProgress(i,2000);
        }
        return null;
    }
}

class Task2 extends Task<Void>{
    @Override
    protected Void call() throws Exception {
        for (int i =0; i<1000; i++) {
            TimeUnit.MILLISECONDS.sleep(100);
            updateProgress(i,2000);
        }
        return null;
    }
}