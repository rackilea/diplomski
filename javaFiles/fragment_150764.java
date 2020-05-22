import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NoFocusTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField tf1 = new TextField();
        tf1.setPromptText("Enter something");
        TextField tf2 = new TextField();
        tf2.setPromptText("Enter something else");
        VBox root = new VBox(5, tf1, tf2);
        primaryStage.setScene(new Scene(root, 250, 150));
        primaryStage.show();
        root.requestFocus();
    }
}