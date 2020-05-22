import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameScene extends Application {

    private Group root;
    @Override
    public void start(Stage stage) {
        root = new Group();
        stage.setScene(getScene());
        stage.show();
    }

    public Scene getScene(){

        Scene scene = new Scene(root);
        Test test = new Test();
        test.run(root);
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Test {

    public void run(Group root) {
        root.getChildren().add(new Rectangle(50, 50, Color.BLACK));
    }
}