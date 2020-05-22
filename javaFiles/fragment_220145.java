import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Rect extends Application {

    @Override
    public void start(Stage stage) {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 500, 600);
        Rectangle rect = new Rectangle(100, 40, 100, 100);
        rect.setArcHeight(50);
        rect.setArcWidth(50);
        rect.setFill(Color.BLUE);

        Color[] palette = new Color[] { Color.RED, Color.BLUE, Color.ORANGE };
        Random rng = new Random();

        Timeline tt1 = new Timeline(
            new KeyFrame(
                Duration.millis(3000), 
                e -> rect.setFill(palette[rng.nextInt(palette.length)]), 
                new KeyValue(rect.yProperty(), 1040)
            )
        );

        tt1.setCycleCount(Animation.INDEFINITE);
        tt1.setAutoReverse(false);
        tt1.play();
        canvas.getChildren().add(rect);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}