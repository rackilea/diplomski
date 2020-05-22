import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UpdateColorContinuously extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setMinSize(600, 600);

        new AnimationTimer() {

            private long start = -1 ;
            private long lastUpdate ;

            @Override
            public void handle(long now) {
                if (start < 0) {
                    start = now ;
                    lastUpdate = now ;
                }
                long elapsed = now - start ;
                double elapsedSeconds  = elapsed / 1_000_000_000.0 ;
                Color newColor = Color.hsb(elapsedSeconds * 5, 1.0, 1.0);
                BackgroundFill fill = new BackgroundFill(newColor, CornerRadii.EMPTY, Insets.EMPTY);
                Background bg = new Background(fill);
                root.setBackground(bg);

                if (now - lastUpdate > 25_000_000) {
                    System.err.println("Warning: frame rendering took "+ (now-lastUpdate)/1_000_000 + " ms");
                }

                lastUpdate = now ;
            }

        }.start();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}