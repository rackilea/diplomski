import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimerSample extends Application  {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group g = new Group();
        Scene scene = new Scene(g, 150, 100);

        ComboBox<Double> timerOptions = createTimerOptions(
                0.5, 1.0, 1.5, 2.0
        );
        g.getChildren().addAll(timerOptions);

        createTimer(timerOptions);

        stage.setScene(scene);
        stage.show();
    }

    private ComboBox<Double> createTimerOptions(double... options) {
        ObservableList<Double> data = FXCollections.observableArrayList();

        for (Double option: options) {
            data.add(option);
        }

        return new ComboBox<Double>(data);
    }

    private void createTimer(ComboBox<Double> timeOptions) {
        final Timeline timer = new Timeline();
        timer.setCycleCount(Timeline.INDEFINITE);

        timeOptions.valueProperty().addListener(new ChangeListener<Double>() {
            @Override
            public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
                resetTimer(timer, newValue);
            }
        });

        timeOptions.getSelectionModel().selectFirst();
    }

    private void resetTimer(Timeline timer, final double timerInterval) {
        KeyFrame keyFrame = new KeyFrame(
            Duration.seconds(timerInterval),
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(
                            "This is called every "
                                    + timerInterval
                                    + " seconds"
                    );
                }
            }
        );

        timer.stop();
        timer.getKeyFrames().setAll(
                keyFrame
        );
        timer.play();
    }
}