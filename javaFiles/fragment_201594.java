import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class UpdateStageTitle extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField titleField = new TextField();
        titleField.textProperty().addListener((obs, oldText, newText) -> 
            primaryStage.setTitle(newText));
        HBox root = new HBox(5, new Label("Window title: "), titleField);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 350, 75);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}