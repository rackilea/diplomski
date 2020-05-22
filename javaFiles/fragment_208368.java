import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScrollBarNotify extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Simple TableView to demonstrate
        TableView<String> tableView = new TableView<>();
        TableColumn<String, String> column = new TableColumn<>("Text");
        column.setCellValueFactory(f -> new SimpleStringProperty(f.getValue()));

        tableView.getColumns().add(column);

        // Add some sample items to our TableView
        for (int i = 0; i < 100; i++) {
            tableView.getItems().add("Item #" + i);
        }

        // Now, let's add a listener to the TableView's scrollbar. We can only access the ScrollBar after the Scene is
        // rendered, so we need to do schedule this to run later.
        Platform.runLater(() -> {
            ScrollBar tvScrollBar = (ScrollBar) tableView.lookup(".scroll-bar:vertical");
            tvScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
                if ((Double) newValue == 1.0) {
                    System.out.println("Bottom!");
                }
            });

        });

        // Finally, add the TableViewto our layout
        root.getChildren().add(tableView);

        // Show the Stage
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}