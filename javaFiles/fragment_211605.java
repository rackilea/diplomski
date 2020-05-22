import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** Rotates and places it in a canvas */
public class RotatedImageInCanvas extends Application {
    @Override public void start(Stage stage) {
        Image image = new Image(
            "http://worldpress.org/images/maps/world_600w.jpg", 350, 0, true, true
        );

        // creates a canvas on which rotated images are rendered.
        Canvas canvas = new Canvas(600, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        ImageView iv = new ImageView(image);
        iv.setRotate(40);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = iv.snapshot(params, null);
        gc.drawImage(rotatedImage, 0, 0);

        // supplies a tiled background image on which the canvas is drawn.
        StackPane stack = new StackPane();
        stack.setMaxSize(canvas.getWidth(), canvas.getHeight());
        stack.setStyle("-fx-background-image: url('http://1.bp.blogspot.com/_wV5JMD1OISg/TDYTYxuxR4I/AAAAAAAAvSo/a0zT8nwPV8U/s400/louis-vuitton-nice-beautiful.jpg');");
        stack.getChildren().add(
                canvas
        );

        // places a resizable padded frame around the canvas.
        StackPane frame = new StackPane();
        frame.setPadding(new Insets(20));
        frame.getChildren().add(stack);

        stage.setScene(new Scene(frame, Color.BURLYWOOD));
        stage.show();
    }

    public static void main(String[] args) { launch(RotatedImageInCanvas.class); }
}