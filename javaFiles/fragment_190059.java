import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Synchronicity extends Application {
    private static final double N = 10;
    private static final double R = 10;
    private static final Duration D = Duration.seconds(2);

    private static final double MIN_VAL = 0.1;
    private static final double MAX_VAL = 1;

    private static final Random r = new Random();

    private final DoubleProperty opacity = new SimpleDoubleProperty(MAX_VAL);
    private final Timeline oscillator = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(opacity, MAX_VAL, Interpolator.EASE_BOTH)),
            new KeyFrame(D.divide(2), new KeyValue(opacity, MIN_VAL, Interpolator.EASE_BOTH))
    );

    @Override
    public void start(final Stage stage) {
        Pane layout = new Pane();
        for (int i = 0; i < N; i++) {
            Circle circle = new Circle(R, Color.FIREBRICK);
            circle.setCenterX(2 * R + i * R * 3);
            circle.setCenterY(R * 2);
            layout.getChildren().add(circle);

            PauseTransition pause = new PauseTransition(D.multiply(r.nextDouble() * N));
            pause.setOnFinished(e ->  blink(circle));
            pause.play();
        }
        layout.setMinSize(R + N * R * 3,R * 4);

        stage.setScene(new Scene(layout));
        stage.show();

        oscillator.setAutoReverse(true);
        oscillator.setCycleCount(Timeline.INDEFINITE);
        oscillator.play();
    }

    private void blink(Node node) {
        node.opacityProperty().bind(opacity);
    }

    public static void main(String[] args) {
        launch(args);
    }
}