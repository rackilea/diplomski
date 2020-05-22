import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class DraggingPopup extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Show popup");
        button.setOnAction(event -> showDraggablePopup(primaryStage));
        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 250, 75);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showDraggablePopup(Stage owner) {
        Popup popup = new Popup();
        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> popup.hide());
        StackPane container = new StackPane(closeButton);
        container.setStyle("-fx-background-color: steelblue;");
        container.setMinWidth(300);
        container.setMinHeight(125);

        // Dragging implementation:

        ObjectProperty<Point2D> mouseLocation = new SimpleObjectProperty<>();

        container.setOnMousePressed(event -> 
            mouseLocation.set(new Point2D(event.getScreenX(), event.getScreenY())));

        container.setOnMouseDragged(event -> {
            if (mouseLocation.get() != null) {
                double x = event.getScreenX();
                double deltaX = x - mouseLocation.get().getX() ;
                double y = event.getScreenY();
                double deltaY = y - mouseLocation.get().getY() ;
                //in case of 2 or more computer screens this help me to avoid get stuck on 1 screen
                if(Math.abs(popup.getX()-x)>popup.getWidth()){
                   popup.setX(x);
                   popup.setY(y);
                }else {
                popup.setX(popup.getX() + deltaX);
                popup.setY(popup.getY() + deltaY);
                }
                mouseLocation.set(new Point2D(x, y));
            }
        });

        container.setOnMouseReleased(event -> mouseLocation.set(null));

        popup.getScene().setRoot(container);
        popup.show(owner);
    }

    public static void main(String[] args) {
        launch(args);
    }
}