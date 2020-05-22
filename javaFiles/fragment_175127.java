import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClockView extends Application {
    Pane background;
    static Text firstDigit;
    static Text secondDigit;
    static Text thirdDigit;
    static Text fourthDigit;
    Text middleDecimal;

    public final Timer clockTimer = new Timer();


    /* Sets the first digit of the base 10 time to the passed through char. */
    static void setFirstDigit(char x1) {
        String digitString = "";
        digitString += x1;
        firstDigit.setText(digitString);
    }

    /* Sets the second digit of the base 10 time to the passed through char. */
    static void setSecondDigit(char x2) {
        String digitString = "";
        digitString += x2;
        secondDigit.setText(digitString);
    }

    /* Sets the third digit of the base 10 time to the passed through char. */
    static void setThirdDigit(char y1) {
        String digitString = "";
        digitString += y1;
        thirdDigit.setText(digitString);
    }

    /* Sets the fourth digit of the base 10 time to the passed through char. */
    static void setFourthDigit(char y2) {
        String digitString = "";
        digitString += y2;
        fourthDigit.setText(digitString);
    }

    /* Main Method that Launches the GUI */
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        final double TEXTFIELD_LAYOUT_Y = 200;

        //Background Pane
        background = new Pane();

        //First digit textField
        firstDigit = new Text("0");
        firstDigit.setLayoutX(17);
        firstDigit.setLayoutY(TEXTFIELD_LAYOUT_Y);
        firstDigit.setStyle("-fx-font-size: 96pt;");

        //Second digit textField
        secondDigit = new Text("0");
        secondDigit.setLayoutX(117);
        secondDigit.setLayoutY(TEXTFIELD_LAYOUT_Y);
        secondDigit.setStyle("-fx-font-size: 96pt;");

        //Middle decimal
        middleDecimal = new Text(".");
        middleDecimal.setLayoutX(219);
        middleDecimal.setLayoutY(210);
        middleDecimal.setStyle("-fx-font-size: 72pt;");

        //Third digit textField
        thirdDigit = new Text("0");
        thirdDigit.setLayoutX(250);
        thirdDigit.setLayoutY(TEXTFIELD_LAYOUT_Y);
        thirdDigit.setStyle("-fx-font-size: 96pt;");

        //Fourth digit textField
        fourthDigit = new Text("0");
        fourthDigit.setLayoutX(362);
        fourthDigit.setLayoutY(TEXTFIELD_LAYOUT_Y);
        fourthDigit.setStyle("-fx-font-size: 96pt;");

        /* Adding the Nodes to the Pane */
        background.getChildren().addAll(firstDigit, secondDigit, middleDecimal, thirdDigit, fourthDigit);

        /* Setting the Scene */
        Scene scene = new Scene(new Group(), 470, 258);
        Group root = (Group)scene.getRoot();
        root.getChildren().add(background);
        primaryStage.setTitle("Base 10 Clock");
        primaryStage.setScene(scene);
        primaryStage.show();

        clockTimer.scheduleAtFixedRate(new TimerTask() {

                Calendar now;
                double currentTime;
                String timeString;
                long timestamp;

                @Override
                public void run() { 
                    /*
                     * Calculates the time in base 10 time and calls the 4 methods
                     * to set the GUI display.
                     * 
                     * In a constant while loop in order to continuously update
                     * the GUI.
                     */
                    now = Calendar.getInstance();
                    timestamp = now.get(Calendar.HOUR_OF_DAY)*60*60 + now.get(Calendar.MINUTE)*60 + now.get(Calendar.SECOND);
                    currentTime = timestamp/86400.0;
                    timeString = "" + currentTime;
                    Platform.runLater(new Runnable() {
                        @Override  public void run() {
                            setFirstDigit(timeString.charAt(2));
                            setSecondDigit(timeString.charAt(3));
                            setThirdDigit(timeString.charAt(4));
                            setFourthDigit(timeString.charAt(5));
                        }
                    });
                }
            }, 0, 8640  // Sleep for 8.64 seconds since that is how long it is between
        );              // increments of 0.01 in base 10 time.
    }
}