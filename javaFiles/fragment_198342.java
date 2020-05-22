import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application{

    private static int MOVEMENT_SPEED = 10;
    private static int RADIUS = 10;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final Circle circle = createCircle();
        final Group group = new Group( circle);
        Scene scene = new Scene(group,  700, 700);
        move(scene, circle);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void move(Scene scene, final Circle circle) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case W:
                    if(circle.getCenterY() > RADIUS)
                        circle.setCenterY(circle.getCenterY() - MOVEMENT_SPEED);
                    break;
                case D:
                    if(circle.getCenterX() < scene.getWidth() - RADIUS)
                        circle.setCenterX(circle.getCenterX() + MOVEMENT_SPEED);
                    break;
                case S:
                    if(circle.getCenterY() < scene.getHeight() - RADIUS)
                        circle.setCenterY(circle.getCenterY() + MOVEMENT_SPEED);
                    break;
                case A:
                    if(circle.getCenterX() > RADIUS)
                        circle.setCenterX(circle.getCenterX() - MOVEMENT_SPEED);
                    break;
            }
        });
    }

    private Circle createCircle() {
        final Circle circle = new Circle(10, 10, RADIUS, Color.BLACK);
        circle.setOpacity(0.7);
        return circle;
    }
}