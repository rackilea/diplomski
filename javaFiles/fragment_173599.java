import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = SceneFactory.getBarChartScene();
        stage.setScene(scene);
        stage.setTitle("Bar Chart Sample");
        stage.show();
    }
}