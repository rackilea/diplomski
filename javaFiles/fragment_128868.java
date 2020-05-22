import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SequentialTransitionExample extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label label = new Label("Hello");

        int totalAnimationTime = 2000 ; // millis
        double[] points = {0,0, 100, 100, 100, 0} ;

        SequentialTransition animation = new SequentialTransition();
        int numPaths = points.length / 2 - 1 ;
        int time = totalAnimationTime / numPaths ;
        for (int i = 2 ; i < points.length - 1; i += 2) {
            MoveTo moveTo = new MoveTo(points[i-2], points[i-1]);
            LineTo lineTo = new LineTo(points[i], points[i+1]);
            Path path = new Path(moveTo, lineTo);
            PathTransition pathTransition = new PathTransition(Duration.millis(time), path, label);

            int p = i / 2 ;
            pathTransition.setOnFinished(e -> System.out.println("Reached point "+p));

            animation.getChildren().add(pathTransition);
        }

        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        animation.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}