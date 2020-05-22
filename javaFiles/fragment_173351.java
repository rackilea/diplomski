import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class TestApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene theScene = new Scene(root);
        stage.setScene(theScene);

        Canvas canvas = new Canvas(512, 820);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        ArrayList<Lasser> allLassers = new ArrayList<>();

        Random randGen = new Random();

        for (int i = 0; i < 10; i++) {
            // create 10 lessers with different self-destruction time
            // on random places
            allLassers.add(new Lasser(randGen.nextInt(500) + 10, 800, i * 1000));
        }

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // Clear the canvas
                gc.clearRect(0, 0, 512, 820);

                for (Lasser l : allLassers) {
                    // if the current object is still ok
                    if (!l.isDestroyed()) {
                        // draw it
                        gc.fillRect(l.getxPos(), l.getyPos(), l.getWidth(), l.getHeight());
                    }
                }

                // remove all destroyed object
                for (int i = allLassers.size() - 1; i >= 0; i--) {
                    if (allLassers.get(i).isDestroyed()) {
                        allLassers.remove(i);
                    }
                }
            }
        }.start();

        stage.show();
    }
}