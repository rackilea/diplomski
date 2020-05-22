import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SlidingNotificationWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Show notification");
        button.setOnAction(e -> {
            Popup window = new Popup();
            StackPane content = new StackPane(new Label("Notification"));
            content.setStyle("-fx-background-color: aquamarine; -fx-padding: 40;");
            content.setOnMouseClicked(evt -> window.hide());
            window.getContent().add(content);
            window.setWidth(120);
            window.setHeight(75);

            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

            double startPos = primaryScreenBounds.getMaxY();
            double endPos = 2*primaryScreenBounds.getMinY()/3 + primaryScreenBounds.getMaxY() / 3 ;
            DoubleProperty y = new SimpleDoubleProperty(startPos);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(y, endPos)));
            y.addListener((obs, oldValue, newValue) ->
                window.setY(newValue.doubleValue()));
            timeline.play();
            window.setX(primaryScreenBounds.getMaxX() - 120);
            window.show(primaryStage);
        });

        StackPane root = new StackPane(button);
        primaryStage.setScene(new Scene(root, 350, 120));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}