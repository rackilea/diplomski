import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class AligningPains extends Application {

    private static final int N_POINTS = 5;
    private static final int MAX_POINT_POS = 100;
    private static final int POINT_RADIUS = 6;
    private static final int PREF_PANE_SIZE = 300;
    private static final int BUTTON_INSETS = 5;

    Point2D[] points = new Point2D[N_POINTS];
    Random random = new Random(42);

    @Override
    public void start(Stage stage) {
        initPoints();

        Pane pane = new Pane();
        pane.setPrefSize(PREF_PANE_SIZE, PREF_PANE_SIZE);

        addCircles(pane, Color.GREEN);

        Pane smallPane = new Pane();
        smallPane.setStyle("-fx-border-color: black;");
        smallPane.setPrefSize(PREF_PANE_SIZE, PREF_PANE_SIZE);
        smallPane.setScaleX(0.25);
        smallPane.setScaleY(0.25);

        addCircles(smallPane, Color.RED);

        Group smallGroup = new Group(smallPane);

        Button startBtn = new Button("Start");

        StackPane stackPane = new StackPane(pane, smallGroup, startBtn);
        StackPane.setAlignment(smallGroup, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(startBtn, Pos.TOP_RIGHT);
        StackPane.setMargin(startBtn, new Insets(BUTTON_INSETS));
        stackPane.setPrefSize(PREF_PANE_SIZE, PREF_PANE_SIZE);

        Scene scene = new Scene(stackPane);
        stage.setScene(scene);
        stage.show();
    }

    private void addCircles(Pane pane, Color color) {
        for (Point2D sp : points) {
            Circle circle = new Circle(sp.getX(), sp.getY(), POINT_RADIUS, color);
            pane.getChildren().add(circle);
        }
    }

    private void initPoints() {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point2D(random.nextInt(MAX_POINT_POS), random.nextInt(MAX_POINT_POS));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}