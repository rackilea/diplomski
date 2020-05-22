import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawRectangle extends Application {

    private static final int W = 500;
    private static final int H = 400;

    private Point2D savedPoint = null;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(W, H);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setOnMouseClicked(event -> {
            switch (event.getButton()) {
                case PRIMARY   -> handlePrimaryClick(gc, event);
                case SECONDARY -> gc.clearRect(0, 0, W, H);
            }
        });

        stage.setResizable(false);
        stage.setScene(new Scene(new StackPane(canvas), W, H));
        stage.show();
    }

    private void handlePrimaryClick(GraphicsContext gc, MouseEvent event) {
        Point2D clickPoint = new Point2D(event.getX(), event.getY());

        if (savedPoint == null) {
            savedPoint = clickPoint;
        } else {
            Rectangle2D rectangle2D = getRect(savedPoint, clickPoint);

            gc.setFill(Color.BLUE);
            gc.fillRect(
                    rectangle2D.getMinX(),
                    rectangle2D.getMinY(),
                    rectangle2D.getWidth(),
                    rectangle2D.getHeight()
            );

            savedPoint = null;
        }
    }

    private Rectangle2D getRect(Point2D p1, Point2D p2) {
        return new Rectangle2D(
                Math.min(p1.getX(), p2.getX()),
                Math.min(p1.getY(), p2.getY()),
                Math.abs(p1.getX() - p2.getX()),
                Math.abs(p1.getY() - p2.getY())
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}