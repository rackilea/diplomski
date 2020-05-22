import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CloseWindowOnClickOutside extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button showPopup = new Button("Show popup");
        showPopup.setOnAction(e -> {
            Stage popup = new Stage();
            Scene scene = new Scene(new Label("Popup"), 120, 40);
            popup.setScene(scene);
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.initOwner(primaryStage);
            popup.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
                if (! isNowFocused) {
                    popup.hide();
                }
            });
            popup.show();
        });

        StackPane root = new StackPane(showPopup);
        Scene scene = new Scene(root, 350, 120);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}