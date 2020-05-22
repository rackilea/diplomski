import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){ Application.launch(args); }

    public void start(Stage stage) {
        Rectangle[] rectangles = {
            new Rectangle(10, 10, 10, 10),
            new Rectangle(20, 20, 10, 10),
            new Rectangle(30, 30, 10, 10),
            new Rectangle(40, 40, 10, 10),
            new Rectangle(50, 50, 10, 10)
        };

        Group root = new Group();
        root.getChildren().addAll(rectangles);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}