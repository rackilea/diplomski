import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();

        Rectangle[] recs = new Rectangle[10];
        for (int i = 0; i < recs.length; i++) {
            recs[i] = new Rectangle(30, 30, Color.GREEN);
            recs[i].setStroke(Color.BLACK);
            gridPane.add(recs[i], i, 0);
        }

        primaryStage.setTitle("Code after primaryStage.show()");
        primaryStage.setScene(new Scene(gridPane, 400, 300));
        primaryStage.show();

        new Thread(() -> {
            for (Rectangle rec :
                    recs) {
                try {
                    Thread.sleep(1000);
                    Platform.runLater(() -> rec.setFill(Color.ORANGE));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void main(String[] args) {
        launch(args);
    }
}