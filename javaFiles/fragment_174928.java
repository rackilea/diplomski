import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class T15DrawEllipses extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 900, 600);

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Ellipse e = new Ellipse();
                e.setCenterX(44 + col * 90);
                e.setCenterY(29 + row * 60);
                e.setRadiusX(45);
                e.setRadiusY(30);
                group.getChildren().add(e);
            }
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}