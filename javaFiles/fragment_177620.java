import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ContextMenuDemo extends Application {

    private DropShadow ds = new DropShadow();

    @Override
    public void start(Stage primaryStage) {

        final Line line1 = new Line(60, 10, 150, 10);
        final Line line2 = new Line(60, 30, 150, 50);
        final Line line3 = new Line(60, 60, 150, 90);

        final ContextMenu cm = new ContextMenu();
        cm.getItems().add(getMenuItemForLine("line 1", line1));
        cm.getItems().add(getMenuItemForLine("line 2", line2));
        cm.getItems().add(getMenuItemForLine("line 3", line3));

        final Rectangle rectangle = new Rectangle(70, 70, Color.TAN);
        rectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (e.getButton() == MouseButton.SECONDARY) {
                    cm.show(rectangle, e.getScreenX(), e.getScreenY());
                }
            }
        });

        Group root = new Group();
        root.getChildren().addAll(rectangle, line1, line2, line3);
        Scene scene = new Scene(root, 300, 250);
        // load style of modified paddings for menuitems
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuItem getMenuItemForLine(String menuName, final Line line) {

        Label menuLabel = new Label(menuName);
        // apply style to occupy larger space for label
        menuLabel.setStyle("-fx-padding: 5 10 5 10");
        MenuItem mi = new MenuItem();
        mi.setGraphic(menuLabel);
        line.setStroke(Color.BLUE);

        menuLabel.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                line.setStroke(Color.RED);
                line.setEffect(ds);
            }
        });

        menuLabel.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                line.setStroke(Color.BLUE);
                line.setEffect(null);
            }
        });

        return mi;
    }

    public static void main(String[] args) {
        launch(args);
    }
}