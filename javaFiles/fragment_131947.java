import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxAlignment extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Simple ComboBox with items
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet");

        // Provide our own ListCells for the ComboBox
        comboBox.setCellFactory(lv -> new ListCell<String>() {

            // We override the updateItem() method
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                // Set the style for this ListCell
                setStyle("-fx-alignment: center");

                // If there is no item for this cell, leave it empty, otherwise show the text
                if (item != null && !empty) {
                    setText(item);
                } else {
                    setText(null);
                }
            }
        });

        root.getChildren().add(comboBox);

        // Show the Stage
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}