import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import tomek.szypula.math.Vector2D;

import java.util.concurrent.Callable;

public class ColorBindingTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    final private double maxSpeed = 10;
    final private double maxColor = 110; //Green

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene theScene = new Scene( root,1100, 800 );
        primaryStage.setTitle("ColorBindingTest");
        primaryStage.setScene(theScene);

        Circle carShape  = new Circle();
        Vector2D speed = new Vector2D();

        carShape.setCenterX(100);
        carShape.setCenterY(100);
        carShape.setRadius(10);

        root.getChildren().add(carShape);

        ObjectBinding<Color> colorObjectBinding1 = Bindings.createObjectBinding(
                new Callable<Color>() {
                    @Override
                    public Color call() throws Exception {
                        double speedX = speed.getX();
                        double speedY = speed.getY();
                        Color color = Color.hsb(Math.sqrt(speedX*speedX+speedY*speedY)*maxColor/maxSpeed,0.94,0.94,0.94);
                        return color;
                    }
                },speed.getXProperty(),speed.getYProperty()
        );
        carShape.fillProperty().bind(colorObjectBinding1);

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(200),
                ae -> {
                    speed.setX(Math.random()*maxSpeed);
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        primaryStage.show();
    }
}