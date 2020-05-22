import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Main extends Application {

    private Pane pane;
    private Point2D origin;
    private Ellipse ellipse;

    @Override
    public void start(Stage primaryStage) {
        pane = new Pane();
        pane.setOnMousePressed(this::handleMousePressed);
        pane.setOnMouseDragged(this::handleMouseDragged);
        pane.setOnMouseReleased(this::handleMouseReleased);

        primaryStage.setScene(new Scene(pane, 600.0, 400.0));
        primaryStage.show();
    }

    private void handleMousePressed(MouseEvent event) {
        event.consume();

        origin = new Point2D(event.getX(), event.getY());
        ellipse = new Ellipse(event.getX(), event.getY(), 0.0, 0.0);
        pane.getChildren().add(ellipse);
    }

    private void handleMouseDragged(MouseEvent event) {
        event.consume();

        ellipse.setCenterX((origin.getX() + event.getX()) / 2.0);
        ellipse.setCenterY((origin.getY() + event.getY()) / 2.0);
        ellipse.setRadiusX(Math.abs(event.getX() - origin.getX()) / 2.0);
        ellipse.setRadiusY(Math.abs(event.getY() - origin.getY()) / 2.0);
    }

    private void handleMouseReleased(MouseEvent event) {
        event.consume();

        ellipse = null;
        origin = null;
    }

}