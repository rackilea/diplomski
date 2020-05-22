import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class VariableLine extends Application {
    private static final double S = 100;

    @Override
    public void start(Stage stage) throws Exception {
        RandomRotator randomRotator = new RandomRotator();

        Line line = new Line(0, S, S, S);
        randomRotator.getRotate().setPivotY(S);
        line.getTransforms().add(randomRotator.getRotate());

        Label maxValueText = new Label(randomRotator.getMaxAngle() + "");
        maxValueText.textProperty().bind(randomRotator.maxAngleProperty().asString());

        stage.setScene(new Scene(new Pane(maxValueText, line), S, S * 2));
        stage.show();

        randomRotator.getTimeline().play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class RandomRotator {
    private static final Random random = new Random(42);

    private static final double INIT_ANGLE = -40;
    private static final double MAX_ANGLE = 90;
    private static final Duration ROTATION_DURATION = Duration.seconds(3);

    private final ReadOnlyDoubleWrapper maxAngle = new ReadOnlyDoubleWrapper(INIT_ANGLE);
    private final Timeline timeline = new Timeline();
    private final Rotate rotate = new Rotate(INIT_ANGLE);

    RandomRotator() {
        timeline.getKeyFrames().addAll(
            new KeyFrame(
                    Duration.seconds(0),
                    new KeyValue(rotate.angleProperty(), INIT_ANGLE)
            ),
            new KeyFrame(
                    ROTATION_DURATION.divide(2), 
                    new KeyValue(rotate.angleProperty(), maxAngle.get())
            ),
            new KeyFrame(
                    ROTATION_DURATION,
                    new KeyValue(rotate.angleProperty(), INIT_ANGLE)
            )
        );

        timeline.setOnFinished(event -> {
            maxAngle.set(random.nextInt((int) MAX_ANGLE));
            timeline.getKeyFrames().set(
                    1,
                    new KeyFrame(
                            ROTATION_DURATION.divide(2), 
                            new KeyValue(rotate.angleProperty(), maxAngle.get())
                    )
            );
            timeline.playFromStart();
        });
    }

    Rotate getRotate() {
        return rotate;
    }

    public double getMaxAngle() {
        return maxAngle.get();
    }

    public ReadOnlyDoubleProperty maxAngleProperty() {
        return maxAngle.getReadOnlyProperty();
    }

    public Timeline getTimeline() {
        return timeline;
    }
}