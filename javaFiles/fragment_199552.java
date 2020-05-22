import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

class Sprite extends ImageView {
    private final Rectangle2D[] cellClips;
    private int numCells;
    private final Timeline timeline;
    private final IntegerProperty frameCounter = new SimpleIntegerProperty(0);

    public Sprite(Image animationImage, int numCells, Duration frameTime) {
        this.numCells = numCells;

        double cellWidth  = animationImage.getWidth() / numCells;
        double cellHeight = animationImage.getHeight();

        cellClips = new Rectangle2D[numCells];
        for (int i = 0; i < numCells; i++) {
            cellClips[i] = new Rectangle2D(
                    i * cellWidth, 0,
                    cellWidth, cellHeight
            );
        }

        setImage(animationImage);
        setViewport(cellClips[0]);

        timeline = new Timeline(
                new KeyFrame(frameTime, event -> {
                    frameCounter.set((frameCounter.get() + 1) % numCells);
                    setViewport(cellClips[frameCounter.get()]);
                })
        );
    }

    public void playOnce() {
        frameCounter.set(0);
        timeline.setCycleCount(numCells);
        timeline.stop();
        timeline.playFromStart();
    }

    public void playContinuously() {
        frameCounter.set(0);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.stop();
        timeline.playFromStart();
    }

    public void stop() {
        frameCounter.set(0);
        setViewport(cellClips[frameCounter.get()]);
        timeline.stop();
    }
}

public class SpriteSample extends Application {
    private static final int NUM_CELLS_PER_ANIMATION = 6;
    private static final Duration FRAME_TIME = Duration.seconds(.5);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // looks likes imgur may have blocked direct access to following png from a Java app (somehow).
        // but you can still download the QMqbQ.png from that location 
        // and save it locally in the same directory as the CatWhack program
        // then pick it up by replacing the new Image call with:
        //    new Image(Sprite.class.getResourceAsStream("QMqbQ.png")); 
        Image tilesheetImage = new Image(SpriteSample.class.getResourceAsStream("QMqbQ.png"));
        Sprite sprite = new Sprite(tilesheetImage, NUM_CELLS_PER_ANIMATION, FRAME_TIME);

        ToggleButton animationControl = new ToggleButton("Animate");
        animationControl.setOnAction(event -> {
            if (animationControl.isSelected()) {
                animationControl.setText("Stop");
                sprite.playContinuously();
            } else {
                animationControl.setText("Animate");
                sprite.stop();
            }
        });

        VBox layout = new VBox(10, sprite, animationControl);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(layout));
        stage.show();
    }
}