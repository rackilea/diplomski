import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

public class CanvasDragController {

    @FXML
    private Pane rootPane;

    @FXML
    private Canvas canvas;

    private double mouseX;

    private double mouseY;

    @FXML
    private void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Set the writing pen.
        gc.setLineCap(StrokeLineCap.ROUND);
        gc.setLineJoin(StrokeLineJoin.ROUND);
        gc.setLineWidth(1);
        gc.setStroke(Color.BLACK);

        // Set the background to be transparent.
        gc.setFill(Color.BLUE);
        gc.fillRect(0, 0, 256, 256);

        // Handle moving the canvas.
        canvas.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                gc.moveTo(e.getX(), e.getY());
            } else if (e.getButton() == MouseButton.SECONDARY) {
                mouseX = e.getSceneX();
                mouseY = e.getSceneY();
            }
        });

        canvas.setOnMouseDragged(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                gc.lineTo(e.getX(), e.getY());
                gc.stroke();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                double newMouseX = e.getSceneX();
                double newMouseY = e.getSceneY();
                double deltaX = newMouseX - mouseX;
                double deltaY = newMouseY - mouseY;
                canvas.setLayoutX(canvas.getLayoutX() + deltaX);
                canvas.setLayoutY(canvas.getLayoutY() + deltaY);
                mouseX = newMouseX;
                mouseY = newMouseY;
                // Why is this happening?
                if (Math.abs(deltaX) > 4 || Math.abs(deltaY) > 4)
                    System.out.println(deltaX + " " + deltaY);
            }
        });
    }
}