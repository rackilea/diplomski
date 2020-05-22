import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HexTime extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(getColoredPane(), 450, 500);
        primaryStage.setTitle("Hexa Time");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public BorderPane getColoredPane() {
        BorderPane pane = new BorderPane();
        Label label = new Label();
        label.setFont(Font.font(20));

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame changeColor = new KeyFrame(Duration.seconds(1),
                new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {
                        Map<String, String> colortime = generateColor();
                        label.setText(colortime.get("time"));
                        label.setStyle("-fx-text-fill: white");
                        pane.setStyle("-fx-background-color : " + colortime.get("color"));
                    }
                });
        timeline.getKeyFrames().add(changeColor);
        timeline.play();
        pane.setCenter(label);
        return pane;

    }

    public Map<String, String> generateColor() {

        int hour;
        int min;
        int sec;
        Calendar cal;
        String hexValue;
        Map<String, String> map = new HashMap<String, String>();

        cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY);
        min = cal.get(Calendar.MINUTE);
        sec = cal.get(Calendar.SECOND);

        // Color Code Production
        hexValue = String.format("%02X%02X%02X", hour, min, sec);
        map.put("color", "#" + hexValue);
        map.put("time", "#" + String.format("%02d", hour) + String.format("%02d", min) + String.format("%02d", sec));
        return map;
    }

    public static void main(String[] args) {
        launch(args);
    }

}