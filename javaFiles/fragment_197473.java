import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomComponentTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new CustomVBox(), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class CustomVBox extends VBox implements CustomComponent {

        @FXML
        private Label label ;

        public CustomVBox() {
            loadFXML("CustomVBox.fxml");
        }

        @FXML
        private void click() {
            System.out.println("Click!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}