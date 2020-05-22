import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 *
 * @author blj0011
 */
final public class IncrementingTimer extends HBox
{
    IntegerProperty secondsCounter = new SimpleIntegerProperty();//Keeps up with seconds
    IntegerProperty minutesCounter = new SimpleIntegerProperty();//Keeps up with minutes

    Label lblSeconds = new Label();//Displays the seconds
    Label lblMinutes = new Label();//Displays the minutes
    Label lblColon = new Label(":");//Display the colon between minutes and seconds

    Button btnPlay = new Button("Play");//Plays the Timeline
    Button btnStop = new Button("Stop");//Stops the Timeline
    Button btnPause = new Button("Pause");//Pauses the Timeline

    Timeline timeline;//Used to run code that changes the Labels. This Timeline runs every one second.

    public IncrementingTimer()
    {
        lblSeconds.textProperty().bind(secondsCounter.asString("%02d"));//Binds the seconds label to the seconds counter. Sets the String to always show two digits. Exmaple 1 is shown as 01.
        lblMinutes.textProperty().bind(minutesCounter.asString("%02d"));//Binds the minutes label to the minutes counter. Sets the String to always show two digits. Exmaple 1 is shown as 01.

        getChildren().addAll(lblMinutes, lblColon, lblSeconds, btnPlay, btnStop, btnPause);

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), (event) -> {//Replace the one with .016 to speed this up for testing purposes.
            secondsCounter.set(secondsCounter.get() + 1);
            if (secondsCounter.get() == 60) {
                secondsCounter.set(0);
                minutesCounter.set(minutesCounter.get() + 1);
                if (minutesCounter.get() == 60) {
                    minutesCounter.set(0);
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        btnPlay.setOnAction((event) -> {
            timeline.play();
        });
        btnPause.setOnAction((event) -> {
            timeline.pause();
        });
        btnStop.setOnAction((event) -> {
            timeline.stop();
            secondsCounter.set(0);
            minutesCounter.set(0);
        });

        this.setAlignment(Pos.CENTER);
    }

}