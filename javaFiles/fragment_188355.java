import javafx.animation.PauseTransition;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

public class NotifyingTextField extends TextField {

  private final Tooltip tooltip = new Tooltip("Copied contents to clipboard");
  private final PauseTransition hideAnimation = new PauseTransition();

  {
    hideAnimation.durationProperty().bind(tooltip.showDurationProperty());
    hideAnimation.setOnFinished(e -> tooltip.hide());
    tooltip.setShowDuration(Duration.seconds(2.0));
  }

  @Override
  public void copy() {
    var selectedText = getSelectedText();
    if (!selectedText.isEmpty()) {
      super.copy();

      var point = localToScreen(0, 0);
      tooltip.show(this, point.getX(), point.getY());
      hideAnimation.playFromStart();
    } 
  }
}