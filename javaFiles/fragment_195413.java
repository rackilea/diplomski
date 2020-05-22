package helloworld;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.time.Duration;

/**
 * Created by Matt on 25/08/16.
 */
public class RotatingARectangle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        Group root = new Group();

        Rectangle rect = new Rectangle(190, 395, 20, 5);
        rect.setFill(Color.BLUE);
        Rotate rot = new Rotate(0, 200, 200);
        rect.getTransforms().add(rot);

        Ellipse path = new Ellipse(200, 200, 200, 200);
        path.setStroke(Color.RED);
        path.setFill(null);

        root.getChildren().add(rect);
        root.getChildren().add(path);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline line = new Timeline(30);

        KeyFrame key1 = new KeyFrame(
                new javafx.util.Duration(0),
                new KeyValue(rot.angleProperty(), 0 )
        );

        KeyFrame key2 = new KeyFrame(
            new javafx.util.Duration(1000),
            new KeyValue(rot.angleProperty(), 360 )
        );
        line.getKeyFrames().addAll(key1, key2);

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, evt->{
            line.playFromStart();
        });



    }

}