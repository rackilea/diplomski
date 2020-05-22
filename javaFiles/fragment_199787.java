import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class FXMLStageTest extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("Stage.fxml"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}