import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class CircleJumper extends Application {
    private static final double MAX_X = 600;
    private static final double MAX_Y = 300;

    private int clickCount = 0;
    private Random random;

    @Override
    public void init() {
        random = new Random();
    }

    @Override
    public void start(Stage stage){
        Circle circle = new Circle(MAX_X / 2, MAX_Y / 2, 30);
        Button button = new Button("Click Me!");
        Text clickCountText = new Text("Clicks: " + clickCount);

        button.setOnAction((event) -> {
            clickCount++;
            clickCountText.setText("Clicks: " + clickCount);

            circle.setCenterX(random.nextInt((int) MAX_X));
            circle.setCenterY(random.nextInt((int) MAX_Y));
        });        

        Group layout = new Group(
                circle,
                new FlowPane(button, clickCountText)
        );

        stage.setScene(new Scene(layout, MAX_X, MAX_Y, Color.CYAN));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}