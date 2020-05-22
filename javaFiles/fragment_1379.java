import java.io.IOException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ResourceTest extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        ResourceBundle resources = ResourceBundle.getBundle("resources");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResourceTest.fxml"), resources);
        Scene scene = new Scene(loader.load(), 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}