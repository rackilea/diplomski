import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FX extends Application {

    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

    Stage stage;
    Scene scene;

    int initialX;
    int initialY;

    @Override
    public void start(Stage s) throws Exception {

        // root
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color:rgb(186,153,122,0.7); -fx-background-radius:30;");

        // Responsive Design
        int sceneWidth = 0;
        int sceneHeight = 0;
        if (screenWidth <= 800 && screenHeight <= 600) {
            sceneWidth = 600;
            sceneHeight = 350;
        } else if (screenWidth <= 1280 && screenHeight <= 768) {
            sceneWidth = 800;
            sceneHeight = 450;
        } else if (screenWidth <= 1920 && screenHeight <= 1080) {
            sceneWidth = 1000;
            sceneHeight = 650;
        }

        // Scene
        stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        scene = new Scene(root, sceneWidth, sceneHeight, Color.TRANSPARENT);

        // Moving
        scene.setOnMousePressed(m -> {
            if (m.getButton() == MouseButton.PRIMARY) {
                scene.setCursor(Cursor.MOVE);
                initialX = (int) (stage.getX() - m.getScreenX());
                initialY = (int) (stage.getY() - m.getScreenY());
            }
        });

        scene.setOnMouseDragged(m -> {
            if (m.getButton() == MouseButton.PRIMARY) {
                stage.setX(m.getScreenX() + initialX);
                stage.setY(m.getScreenY() + initialY);
            }
        });

        scene.setOnMouseReleased(m -> {
            scene.setCursor(Cursor.DEFAULT);
        });

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main Method
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}