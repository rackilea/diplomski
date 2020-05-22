import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonHighlights extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Create a ToggleGroup to hold the list of ToggleButtons. This will allow us to allow the selection of only one
        // ToggleButton at a time
        ToggleGroup toggleGroup = new ToggleGroup();

        // Create our 6 ToggleButtons. For this sample, I will use a for loop to add them to the ToggleGroup. This is
        // not necessary for the main functionality to work, but is used here to save time and space
        for (int i = 0; i < 6; i++) {
            ToggleButton button = new ToggleButton("Button #" + i);

            // If you want different styling for the button when it's selected other than the default, you can either
            // use an external CSS stylesheet, or apply the style in a listener like this:
            button.selectedProperty().addListener((observable, oldValue, newValue) -> {

                // If selected, color the background red
                if (newValue) {
                    button.setStyle(
                            "-fx-background-color: red;" + 
                            "-fx-text-fill: white");
                } else {
                    button.setStyle(null);
                }
            });

            // Add the button to our ToggleGroup
            toggleGroup.getToggles().add(button);
        }

        // Add all our buttons to the scene
        for (Toggle button :
                toggleGroup.getToggles()) {
            root.getChildren().add((ToggleButton) button);
        }

        // Show the Stage
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}