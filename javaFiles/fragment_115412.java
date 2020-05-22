import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane[] scenes = new BorderPane[]{createSceneApple(),createSceneCarrot()};


        StackPane root = new StackPane(scenes[0]);//Set initial view;      

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event) -> {
            if(root.getChildren().get(0).equals(scenes[0]))//If the first scene is loaded, load the second scene.
            {
                root.getChildren().set(0, scenes[1]);
            }
            else
            {
                root.getChildren().set(0, scenes[0]);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        var scene = new Scene(root, 640, 640);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public BorderPane createSceneApple()
    {
        BorderPane borderPane = new BorderPane();

        TextField tf1 = new TextField("Rectangle 1");
        TextField tf2 = new TextField("Rectangle Color: Blue");
        TextArea ta1 = new TextArea("20x40");        
        VBox leftWindow = new VBox(tf1, tf2, ta1);
        borderPane.setLeft(leftWindow);

        StackPane rightWindow = new StackPane(new Rectangle(20, 40, Color.BLUE));
        borderPane.setRight(rightWindow);

        return  borderPane;
    }

    public BorderPane createSceneCarrot()
    {
        BorderPane borderPane = new BorderPane();

        TextField tf1 = new TextField("Circle 1");
        TextField tf2 = new TextField("Circle Color: Blue");
        TextArea ta1 = new TextArea("Radius: 50");        
        VBox leftWindow = new VBox(tf1, tf2, ta1);
        borderPane.setLeft(leftWindow);

        StackPane rightWindow = new StackPane(new Circle(50, Color.RED));
        borderPane.setRight(rightWindow);

        return  borderPane;
    }
}