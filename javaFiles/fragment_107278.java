import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageViewportOnCanvas extends Application {
    public void start(Stage stage) {
        final Image image = new Image(IMAGE_LOC);

        final double w = image.getWidth();
        final double h = image.getWidth();

        final Canvas canvas = new Canvas(w, h);
        canvas.getGraphicsContext2D().drawImage(
                image, 0, 0, w/2, h/2, w/4, h/4, w/2, h/2
        );

        HBox layout = new HBox(
                10,
                new ImageView(image),
                canvas
        );

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static final String IMAGE_LOC = 
        "http://icons.iconarchive.com/icons/jozef89/origami-birds/72/bird-blue-icon.png";
}