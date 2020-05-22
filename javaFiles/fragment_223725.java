import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Sedrick
 */
public class Simon extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button(" 1 ");
        Button btn2 = new Button(" 2 ");
        Button btn3 = new Button(" 3 ");
        Button btn4 = new Button(" 4 ");

        GridPane gridPane = new GridPane();
        gridPane.add(btn1, 0, 0, 1, 1);
        gridPane.add(btn2, 1, 0, 1, 1);
        gridPane.add(btn3, 0, 1, 1, 1);
        gridPane.add(btn4, 1, 1, 1, 1);

        //Create Transistion
        Random random = new Random();
        List<Integer> buttonOrder = new ArrayList();
        int numberOfButtonsToLightUpInOneSeq = 5;//This determines the length of the color sequence
        for(int i = 0; i < numberOfButtonsToLightUpInOneSeq; i++)//This determines the color sequence
        {
            buttonOrder.add(random.nextInt(4));
        }

        List<Timeline> timelines = new ArrayList();//This list will hold the Timelines
        for (Integer seq : buttonOrder)//Create a show color animation and a clear color animation for each Button depending on the sequence
            {
                KeyFrame colorButton = new KeyFrame(Duration.seconds(1),
                        (kfActionEvent) ->
                {
                    switch(seq)
                    {
                        case 0:
                            btn1.setStyle("-fx-background-color: red");
                            break;
                        case 1:
                            btn2.setStyle("-fx-background-color: blue");
                            break;
                        case 2:
                            btn3.setStyle("-fx-background-color: yellow");
                            break;
                        case 3:
                            btn4.setStyle("-fx-background-color: green");
                            break;
                    }
                });

                Timeline showColor = new Timeline();//create the timeline
                showColor.getKeyFrames().addAll(colorButton);//add the frame to the Timeline
                timelines.add(showColor);//add the timeline to the list of timelines

                KeyFrame removeColorFromButton = new KeyFrame(Duration.seconds(1),
                        (kfActionEvent) ->
                {
                    switch(seq)
                    {
                        case 0:
                            btn1.setStyle(null);
                            break;
                        case 1:
                            btn2.setStyle(null);
                            break;
                        case 2:
                            btn3.setStyle(null);
                            break;
                        case 3:
                            btn4.setStyle(null);
                            break;
                    }
                });
                Timeline removeColor = new Timeline();//Create the Timeline
                removeColor.getKeyFrames().addAll(removeColorFromButton);//Add the frame to the Timeline
                timelines.add(removeColor);//Add the time line to the list of Timelines
            }
        //Runs the List of Timeline sequentially
        SequentialTransition sequentialTransition = new SequentialTransition();
            sequentialTransition.getChildren().addAll(timelines);//Add all the Timelines created to a SequentialTransition
            sequentialTransition.play();
            sequentialTransition.setOnFinished(stActionEvent -> 
            {
                timelines.clear();//Once done, clear the animations
            }
        );




        StackPane root = new StackPane();
        root.getChildren().add(gridPane);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}