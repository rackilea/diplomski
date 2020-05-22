package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.util.Duration;

@SuppressWarnings("deprecation")
public class MainControl implements Initializable{
    public void initialize(URL arg0, ResourceBundle arg1) {
    Timeline tick = TimelineBuilder.create()//creates a new Timeline
     .keyFrames(
       new KeyFrame(
            new Duration(10),//This is how often it updates in milliseconds
            new EventHandler<ActionEvent>() {
                  public void handle(ActionEvent t) {
                       //You put what you want to update here
                  }
            }
        )
     )
    .cycleCount(Timeline.INDEFINITE)
    .build();
tick.play();//Starts the timeline
    }
}