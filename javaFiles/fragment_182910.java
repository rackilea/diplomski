import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FocusMenuTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        VBox textFields = new VBox(5, new TextField("One"), new TextField("Two"), new TextField("Three"));
        MenuBar menuBar = new MenuBar();
        Menu edit = new Menu("Edit");
        MenuItem copy = new MenuItem("Copy");

        copy.setOnAction(e -> {
            Node focusOwner = menuBar.getScene().getFocusOwner();
            if (focusOwner instanceof TextInputControl) {
                ((TextInputControl)focusOwner).copy();
            }
        });     

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> {
            Node focusOwner = menuBar.getScene().getFocusOwner();
            if (focusOwner instanceof TextInputControl) {
                ((TextInputControl)focusOwner).paste();
            }
        });

        menuBar.getMenus().add(edit);
        edit.getItems().addAll(copy, paste);
        root.setCenter(textFields);
        root.setTop(menuBar);
        Scene scene = new Scene(root, 400, 400);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}