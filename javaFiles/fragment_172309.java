import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ProgressIndicatorAsCursor extends Application {

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("Start");

        Service<Void> service = new Service<Void>() {
            @Override
            public Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    public Void call() throws Exception {
                        for (int i = 1 ; i <= 1000; i++) {
                            Thread.sleep(10);
                            updateProgress(i, 1000);
                        }
                        return null ;
                    }
                };
            }
        };

        button.disableProperty().bind(service.runningProperty());
        button.setOnAction(e -> service.restart());

        ProgressIndicator pi = new ProgressIndicator();
        pi.progressProperty().bind(service.progressProperty());

        Pane pane = new Pane();

        // fill pane with rectangle as task progresses:
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.CORNFLOWERBLUE);
        rectangle.setX(0);
        rectangle.widthProperty().bind(pane.widthProperty());

        rectangle.heightProperty().bind(pane.heightProperty().multiply(service.progressProperty()));
        rectangle.yProperty().bind(pane.heightProperty().subtract(rectangle.heightProperty()));

        pane.getChildren().add(rectangle);

        Label label = new Label();
        label.graphicProperty().bind(
                Bindings.when(service.runningProperty())
                    .then(pi)
                    .otherwise((ProgressIndicator)null));

        pane.setOnMouseEntered(e -> 
            pane.getChildren().add(label));
        pane.setOnMouseExited(e -> 
            pane.getChildren().remove(label));
        pane.setOnMouseMoved(e -> label.relocate(e.getX(), e.getY()));

        pane.cursorProperty().bind(
                Bindings.when(service.runningProperty())
                    .then(Cursor.NONE)
                    .otherwise(Cursor.DEFAULT));

        BorderPane.setAlignment(button, Pos.CENTER);
        BorderPane.setMargin(button, new Insets(10));
        BorderPane root = new BorderPane(pane, new Rectangle(0,0,0,20), null, button, null);

        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}