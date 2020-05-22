import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TrackMouseStopped extends Application {

    private final long MIN_STATIONARY_TIME = 100_000_000 ; // nanoseconds 

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        BooleanProperty mouseMoving = new SimpleBooleanProperty();
        mouseMoving.addListener((obs, wasMoving, isNowMoving) -> {
           if (! isNowMoving) {
               System.out.println("Mouse stopped!");
           }
        });

        PauseTransition pause = new PauseTransition(Duration.millis(MIN_STATIONARY_TIME / 1_000_000));
        pause.setOnFinished(e -> mouseMoving.set(false));

        // Note: if you want to consider the mouse having moved for
        // other events (e.g. dragging), you can do
        // pane.addEventHandler(MouseEvent.ANY, e -> { ... }); here
        pane.setOnMouseMoved(e -> {
            mouseMoving.set(true);
            pause.playFromStart();
        });

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}