import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GamePractice extends Application {

    private Pane canvas;

    @Override
    public void start(final Stage primaryStage) {

        canvas = new Pane();
        final Scene scene = new Scene(canvas, 800, 600);

        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        addCircle(100, 100, Color.BLUE);


        scene.setOnMousePressed(new EventHandler<MouseEvent>() {         
            @Override         
            public void handle(MouseEvent event) {  
                if (event.getButton() == MouseButton.PRIMARY) {
                    if (!(canvas.getChildren().isEmpty())) {
                        canvas.getChildren().remove(0);
                    }   
                }
                else {
                    int red = (int)(Math.random()*256);
                    int green = (int)(Math.random()*256);
                    int blue = (int)(Math.random()*256);
                    int x = (int)(Math.random()*801);
                    int y = (int)(Math.random()*601);
                    addCircle(x, y, Color.rgb(red, green, blue));
                }
            }     
        }); 

    }

    private void addCircle(double x, double y, Color color) {
        Circle circle = new Circle(15, color);
        circle.relocate(x, y);

        canvas.getChildren().addAll(circle);


        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            double deltaX = (double)(Math.random()*10) + 3;
            double deltaY = (double)(Math.random()*10) + 3;


            @Override
            public void handle(final ActionEvent t) {
                circle.setLayoutX(circle.getLayoutX() + deltaX);
                circle.setLayoutY(circle.getLayoutY() + deltaY);

                final Bounds bounds = canvas.getBoundsInLocal();
                final boolean atRightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
                final boolean atLeftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
                final boolean atBottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
                final boolean atTopBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());

                if (atRightBorder || atLeftBorder) {
                    deltaX *= -1;
                }
                if (atBottomBorder || atTopBorder) {
                    deltaY *= -1;
                }
            }
        }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();

    }

    public static void main(final String[] args) {
        launch(args);
    }
}