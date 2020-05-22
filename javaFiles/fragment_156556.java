import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Starfield extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group layout = new Group();

        Star[] stars = createStars(layout);
        animateStars(stars);

        Scene sim = new Scene(layout, 800, 800, true);
        sim.setFill(Color.BLACK);
        sim.setCamera(new PerspectiveCamera());

        stage.setScene(sim);
        stage.show();
    }

    private void animateStars(final Star[] stars) {
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                for (Star star : stars) {
                    star.update();
                }
            }
        }.start();
    }

    private Star[] createStars(Group layout) {
        Star[] stars = new Star[100];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
            layout.getChildren().add(
                    stars[i]
            );
        }
        return stars;
    }

    public class Star extends Circle {
        public Star() {
            super(5, Color.WHITE);
            setTranslateX(Math.random() * 800);
            setTranslateY(Math.random() * 800);
            setTranslateZ(Math.random() * 800);
        }

        public void update() {
            double newTranslateZ = getTranslateZ() - 10;
            if (newTranslateZ < -2000) {
                newTranslateZ = Math.random() * 800;
            }

            setTranslateZ(newTranslateZ);
        }
    }
}