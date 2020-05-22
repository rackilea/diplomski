import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ShapesTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private double arrayStartX;
    private double arrayStartY;
    private AnchorPane root;
    private Line l;

    @Override
    public void start(Stage stage) {

        root = new AnchorPane();

        root.addEventHandler(MouseEvent.MOUSE_PRESSED, ev -> {
            addBall(ev.getX(), ev.getY());
            arrayStartX = ev.getX();
            arrayStartY = ev.getY();

        });

        root.addEventHandler(MouseEvent.MOUSE_DRAGGED, ev -> {
            if (l == null) {
                addLine(ev.getX(), ev.getY());
            } else {
                l.setEndX(ev.getX());
                l.setEndY(ev.getY());
            }

        });

        root.addEventHandler(MouseEvent.MOUSE_RELEASED, ev -> {
            l = null;
        });

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();

    }

    private void addLine(double x, double y) {
        l = new Line(arrayStartX, arrayStartY, x, y);
        root.getChildren().add(l);

    }

    private void addBall(double x, double y) {
        Circle c = new Circle(x, y, 15);
        c.fillProperty().set(Color.DARKCYAN);
        root.getChildren().add(c);
    }
}