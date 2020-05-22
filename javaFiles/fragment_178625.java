import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CustomLabelDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello World");
        label.setStyle(
            "-fx-alignment: center;"
            +"-fx-padding: 6px;"
            +"-fx-background-color: red, -fx-background;"
            +"-fx-background-insets: 0, 4px;"
        );
        StackPane root = new StackPane(label);
        primaryStage.setScene(new Scene(root, 350, 75));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}