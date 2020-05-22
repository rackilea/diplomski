import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ArcCenter extends Application {
    @Override
    public void start(Stage stage) {
        Path arcPath1 = new Path(
                new MoveTo(50, 25),
                new ArcTo(30, 15, 0, 100, 50, false, true)
        );
        arcPath1.setStrokeWidth(2);
        arcPath1.setStroke(Color.ORANGE);

        Path arcPath2 = new Path(
                new MoveTo(30, 40),
                new ArcTo(10, 5, 0, 60, 60, false, true)
        );
        arcPath2.setStrokeWidth(2);
        arcPath2.setStroke(Color.HOTPINK);

        Circle arcMidpoint1 = calcMidpoint(arcPath1, Color.FORESTGREEN);
        Circle arcMidpoint2 = calcMidpoint(arcPath2, Color.FORESTGREEN);

        Group group = new Group(
                arcPath1,
                arcPath2,
                arcMidpoint1,
                arcMidpoint2
        );

        arcMidpoint2.translateYProperty().addListener((observable, oldValue, newValue) -> {
            Path line = new Path(
                    new MoveTo(arcMidpoint1.getTranslateX(), arcMidpoint1.getTranslateY()),
                    new LineTo(arcMidpoint2.getTranslateX(), arcMidpoint2.getTranslateY())
            );
            line.setStroke(Color.LIGHTBLUE);
            line.setStrokeWidth(2);
            group.getChildren().add(line);
            line.toBack();

            Circle lineMidpoint = calcMidpoint(line, Color.RED.darker());
            lineMidpoint.translateYProperty().addListener((o, old, newV) -> {
                System.out.println(
                    "Path center point: ( " +
                    lineMidpoint.getTranslateX() + ", " +
                    lineMidpoint.getTranslateY() + " )"
                );
            });
            group.getChildren().add(lineMidpoint);
        });

        group.setScaleX(2);
        group.setScaleY(2);

        stage.setScene(
                new Scene(
                        new StackPane(new Group(group)),
                        300, 200,
                        Color.rgb(35, 39, 50)
                )
        );
        stage.show();
    }

    private Circle calcMidpoint(Path path, Color midpointColor) {
        Circle midpoint = new Circle(3, midpointColor);

        PathTransition pathTransition = new PathTransition(Duration.minutes(10), path, midpoint);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setInterpolator(Interpolator.LINEAR);
        pathTransition.jumpTo(pathTransition.getDuration().divide(2));
        pathTransition.play();

        midpoint.translateYProperty().addListener((observable, oldValue, newValue) -> {
            pathTransition.stop();
        });

        return midpoint;
    }

    public static void main(String[] args) {
        launch(args);
    }
}