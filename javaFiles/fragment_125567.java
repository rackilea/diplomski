import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ContextMenuExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Label label = new Label("Right click here");
        root.getChildren().add(label);

        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem = new MenuItem();
        contextMenu.getItems().add(menuItem);

        final Button button = new Button("Click Me");
        menuItem.setGraphic(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Window window = button.getScene().getWindow();
                System.out.println("window is a stage: "+(window instanceof Stage));
            }
        });
        label.setContextMenu(contextMenu);
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}