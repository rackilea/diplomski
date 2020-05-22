import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RotateLineAboutEnd extends Application {

    @Override
    public void start(Stage primaryStage) {
        Line line = new Line(200, 200, 200, 350);
        Pane pane = new Pane(line);
        Rotate rotation = new Rotate();
        rotation.pivotXProperty().bind(line.startXProperty());
        rotation.pivotYProperty().bind(line.startYProperty());

        line.getTransforms().add(rotation);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(rotation.angleProperty(), 360)));

        Button button = new Button("Rotate");
        button.setOnAction(evt -> timeline.play());
        button.disableProperty().bind(timeline.statusProperty().isEqualTo(Animation.Status.RUNNING));

        HBox controls = new HBox(button);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(12));

        BorderPane root = new BorderPane(pane, null, null, controls, null);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}