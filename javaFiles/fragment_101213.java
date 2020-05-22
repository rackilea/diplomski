import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;

public class MyGameLogic {
    private IntegerProperty scores = new SimpleIntegerProperty(0);

    public void setScore(int scores) {
        this.scores.set(scores);
    }

    public int getScore() {
        return scores.get();
    }

    public IntegerProperty scoreProperty() {
        return scores;
    }
}

class JustAGUIExample {
    private Label scoresLabel;
    private MyGameLogic gameLogic;

    public JustAGUIExample() {
        scoresLabel.textProperty().bind(
            gameLogic.scoreProperty().asString()
        );
    }
}