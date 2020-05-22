import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ClicksInGridPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();

        final int NUM_ROWS = 40 ;
        final int NUM_COLS = 40 ;

        ContextMenu menu = new ContextMenu();
        MenuItem menuItem1 = new MenuItem("Item 1");
        MenuItem menuItem2 = new MenuItem("Item 2");
        menu.getItems().addAll(menuItem1, menuItem2);

        for (int x = 0 ; x < NUM_COLS ; x++) {
            for (int y = 0 ; y < NUM_ROWS ; y++) {
                Pane cell = new Pane();
                cell.setPrefSize(20, 20);
                // add style just to draw grid:
                cell.setStyle("-fx-background-color: black, white; -fx-background-insets: 0, 0 0 1 1;");

                // context menu listener:
                final int col = x ;
                final int row = y ;

                cell.setOnContextMenuRequested(e -> {
                    menuItem1.setOnAction(evt -> System.out.println("Item 1 selected in cell ["+col+", "+row+"]"));
                    menuItem2.setOnAction(evt -> System.out.println("Item 2 selected in cell ["+col+", "+row+"]"));
                    menu.show(cell, e.getScreenX(), e.getScreenY());
                });

                root.add(cell, x, y);
            }
        }

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}