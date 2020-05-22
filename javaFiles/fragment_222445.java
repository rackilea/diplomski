package tests;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.util.Duration;

public class Controller {

    @FXML
    CustomLabel cLabel;
    private int counter = 1;

    @FXML
    private void initialize() {

        cLabel.setTextAndId(String.valueOf(counter++));

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event ->{
            cLabel.setTextAndId(String.valueOf(counter++));
            if(counter > 3) {
                counter = 1;
            }
            pause.play();
        });
        pause.play();
    }
}