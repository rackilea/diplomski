import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView<String> tableView = new TableView<>();
        TableColumn<String, String> tableColumn = new TableColumn<>("Name");

        tableColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

        tableView.getColumns().add(tableColumn);
        ObservableList<String> items = FXCollections.observableArrayList("Itachi");
        tableView.setItems(items);

        VBox root = new VBox(tableView);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}