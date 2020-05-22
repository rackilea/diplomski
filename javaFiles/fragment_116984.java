import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Jose
 */
public class Listener extends Application {

    long prevTime = System.currentTimeMillis();

    @Override
    public void start(Stage primaryStage) {

        Circle circle = new Circle(50);

        Path path2 = PathBuilder.create().elements(new MoveTo(0, 0), new LineTo(0, 80)).build();
        path2.setFill(Color.RED);
        path2.setStroke(Color.RED);
        path2.setStrokeWidth(1);
        path2.setLayoutX(0);
        path2.setLayoutY(0);

        PathTransition pathTransition2 = PathTransitionBuilder.create().duration(javafx.util.Duration.millis(1000)).cycleCount(INDEFINITE).autoReverse(true).path(path2).node(circle).build();

        pathTransition2.currentTimeProperty().addListener(new ChangeListener<Duration>() {

            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {

                long currTime = System.currentTimeMillis();
                if (Double.compare((currTime - prevTime), 250) > 0) {
                    System.out.println("delta: " + (currTime - prevTime) + ", old value: " + oldValue + ", new value: " + newValue);
                    prevTime = currTime;
                }

            }
        });

        pathTransition2.play();

        StackPane root = new StackPane();
        root.getChildren().addAll(path2, circle);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}