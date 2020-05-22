import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TableTest extends Application {

  @Override
  public void start(Stage primaryStage) {
    TextField field = new TextField();

    TableView<String> table = new TableView<>();
    TableColumn<String, String> column = new TableColumn("Header Text");
    table.getColumns().add(column);

    field.prefWidthProperty().bind(column.widthProperty());
    field.minWidthProperty().bind(column.widthProperty());
    field.maxWidthProperty().bind(column.widthProperty());

    VBox root = new VBox();
    root.getChildren().addAll(field, table);

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}