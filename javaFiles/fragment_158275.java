import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GridTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Grid grid = new Grid(10,10);
        grid.setPadding(new Insets(20));
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}