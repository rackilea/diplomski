import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomLabelDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello World");
        label.getStyleClass().add("custom-label");

        Button changeColorButton = new Button("Change to green");
        changeColorButton.setOnAction(event -> label.setStyle("custom-label-border-color: green;"));

        VBox root = new VBox(10, label, changeColorButton);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 350, 75);
        scene.getStylesheets().add("custom-label.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}