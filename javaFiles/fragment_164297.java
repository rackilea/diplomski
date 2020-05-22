import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SubSceneClickTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        for (int i = 0 ; i < 4 ; i++) {
            SubScene subScene = new SubScene(new StackPane(), 300, 300);
            subScene.setFill((i + i / 2) % 2 == 0 ? Color.CORNFLOWERBLUE : Color.AQUA);
            String message = "Click on subscene "+i;
            subScene.setOnMouseClicked(e -> System.out.printf("%s [%.1f, %.1f]%n", message, e.getX(), e.getY()));
            root.add(subScene, i / 2, i % 2);
        }
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}