import javafx.animation.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.util.*;

/**
 *
 * @author Sedrick
 */
public class First  extends Application {

    Stage mainStage;
    Scene mainScene;

    Button mainButton;
    Label mainLabel;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {

        mainStage = stage;
        mainButton = new Button("Begin!");
        mainLabel = new Label("Ready");

        VBox box = new VBox(50);
        box.getChildren().addAll(mainLabel, mainButton);

        mainScene = new Scene(box, 200, 200);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Test Program");
        mainStage.show();

        //Handles Button Press
        mainButton.setOnAction(e -> {
            Second s = new Second();
            mainLabel.textProperty().bind(s.getProperty());
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0),
                            new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent)
                        {
                            s.setStrP(Integer.toString(Integer.parseInt(s.getStrP()) + 1));//I think you should have used an Integer here.
                        }
                    }
                    ),
                    new KeyFrame(Duration.seconds(1))//Do something every second. In this case we are going to increment setStrP.
            );
            timeline.setCycleCount(10);//Repeat this 10 times
            timeline.play();
        });
    }
}



import javafx.beans.property.*;

public class Second {

    private StringProperty strP = new SimpleStringProperty();

    Second()
    {
        setStrP("0");//set to zero
    }
//Get Property

    public StringProperty getProperty()
    {
        return strP;
    }

//Get String
    public String getStrP()
    {
        return strP.get();
    }

//Changes StringProperty every 0.25s
    public void setStrP(String i)
    {
        this.strP.set(i);
    }
}