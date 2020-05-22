import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FullScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            if (primaryStage.isFullScreen() && event.isShortcutDown() && event.isPrimaryButtonDown()) {
                primaryStage.setFullScreen(false);
                event.consume();
            }
        });

        primaryStage.setScene(new Scene(new StackPane()));
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}