import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TrackMouseStopped extends Application {

    private final long MIN_STATIONARY_TIME = 100_000_000 ; // nanoseconds 

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        ObjectProperty<Point2D> mouseLocation = new SimpleObjectProperty<>(new Point2D(0, 0));
        pane.setOnMouseMoved(e -> mouseLocation.set(new Point2D(e.getX(), e.getY())));

        BooleanProperty mouseMoving = new SimpleBooleanProperty();
        mouseMoving.addListener((obs, wasMoving, isNowMoving) -> {
           if (! isNowMoving) {
               System.out.println("Mouse stopped!");
           }
        });

        AnimationTimer timer = new AnimationTimer() {
            private double lastMouseX ;
            private double lastMouseY ;
            long lastMouseMovement ;
            @Override
            public void handle(long timestamp) {
                double x = mouseLocation.get().getX();
                double y = mouseLocation.get().getY();
                if (Double.doubleToLongBits(lastMouseX) != Double.doubleToLongBits(x)
                    || Double.doubleToLongBits(lastMouseY) != Double.doubleToLongBits(y)) {
                    lastMouseMovement = timestamp ;
                }

                mouseMoving.set(timestamp - lastMouseMovement < MIN_STATIONARY_TIME);

                lastMouseX = x;
                lastMouseY = y;
            }
        };
        timer.start();

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}