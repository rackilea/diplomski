import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class NestedColumns extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        TableView<String> tableView = new TableView<String>();
        TableColumn<String, String> nameColumn = new TableColumn<>("Name");
        TableColumn<String, String> firstNameColumn = new TableColumn<>("First name");
        TableColumn<String, String> lastNameColumn = new TableColumn<>("Last name");
        nameColumn.getColumns().addAll(firstNameColumn, lastNameColumn);

        tableView.getColumns().add(nameColumn);

        Scene scene = new Scene(tableView);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}