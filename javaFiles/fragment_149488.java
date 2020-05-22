import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

// displays the width in pixels of an arbitrary piece of text (which has been plotted on a canvas).
public class MeasureText extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final String msg = "XYZZY";
        final Text text = new Text(msg);
        Font font = Font.font("Arial", 20);
        text.setFont(font);

        final double width = text.getLayoutBounds().getWidth();

        Canvas canvas = new Canvas(200, 50);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFont(font);
        gc.fillText(msg, 0, 40);

        stage.setScene(new Scene(
                new VBox(new Label(Double.toString(width)), canvas))
        );
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}