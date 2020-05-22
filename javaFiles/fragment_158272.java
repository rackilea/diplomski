import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GridTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Grid grid = new Grid(10,10);
        Scene scene = new Scene(grid.getView());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}