import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Create the ListView
        ListView<String> listView = new ListView<>();
        listView.getItems().setAll("Title", "One", "Two", "Three", "Four", "Five");

        // Set the CellFactory for the ListView
        listView.setCellFactory(list -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        // There is no item to display in this cell, so leave it empty
                        setGraphic(null);

                        // Clear the style from the cell
                        setStyle(null);
                    } else {
                        // If the item is equal to the first item in the list, set the style
                        if (item.equalsIgnoreCase(list.getItems().get(0))) {
                            // Set the background color to blue
                            setStyle("-fx-background-color: blue; -fx-text-fill: white");
                        }
                        // Finally, show the item text in the cell
                        setText(item);

                    }
                }
            };
            return cell;
        });

        root.getChildren().add(listView);

        // Show the Stage
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}