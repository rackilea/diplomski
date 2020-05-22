import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class OtherController {

  @FXML
  private Rectangle rect;

  public void startAnimation() {
    SequentialTransition transition = new SequentialTransition(
        createTransition(500 - rect.getWidth(), 0),
        createTransition(500 - rect.getWidth(), 300 - rect.getHeight()),
        createTransition(0, 300 - rect.getHeight()),
        createTransition(0, 0)
    );
    transition.setCycleCount(Animation.INDEFINITE);
    transition.play();
  }

  private TranslateTransition createTransition(double x, double y) {
    TranslateTransition tt = new TranslateTransition(Duration.seconds(1), rect);
    tt.setToX(x);
    tt.setToY(y);
    return tt;
  }

}