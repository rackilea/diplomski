import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasWithBorderExample extends Application {

    @Override
    public void start(Stage primaryStage) {

        final int SIZE = 400 ;
        Canvas canvas = new Canvas(SIZE, SIZE);

        GraphicsContext gc = canvas.getGraphicsContext2D() ;
        gc.setStroke(Color.RED);
        gc.moveTo(0, 0);
        gc.lineTo(SIZE, SIZE);
        gc.stroke();

        StackPane canvasContainer = new StackPane(canvas);
        canvasContainer.getStyleClass().add("canvas");

        VBox root = new VBox(10, canvasContainer, new Button("Click here"));
        root.setFillWidth(false);
        VBox.setVgrow(canvasContainer, Priority.NEVER);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("canvas-with-border.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}