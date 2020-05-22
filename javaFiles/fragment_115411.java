import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        List<MyShape> shapes = new ArrayList();
        shapes.add(new MyShape("Circle", "Shape.Circle", "More Circle Info", new Circle(25, Color.BLUE)));
        shapes.add(new MyShape("Rectangle", "Shape.Rectangle", "More Rectangle Info", new Rectangle(100, 50, Color.RED)));
        shapes.add(new MyShape("Line", "Shape.Line", "More Line Info", new Line(0, 0, 100, 100)));


        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextArea ta1 = new TextArea();        
        VBox leftWindow = new VBox(tf1, tf2, ta1);

        StackPane rightWindow = new StackPane(shapes.get(1).getShape());

        AtomicInteger counter = new AtomicInteger();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(counter.get() % shapes.size());
                MyShape currentShape = shapes.get(counter.getAndIncrement() % shapes.size());
                tf1.setText(currentShape.getName());
                tf2.setText(currentShape.getType());
                ta1.setText(currentShape.getMoreInfo());
                rightWindow.getChildren().set(0, currentShape.getShape());
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        BorderPane root = new BorderPane();
        root.setLeft(new StackPane(leftWindow));
        root.setRight(rightWindow);

        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}