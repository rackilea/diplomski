import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

  private Label label;
  private int count;

  @Override
  public void start(Stage primaryStage) {
    label = new Label();

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> incrementLabel()));
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.playFromStart();

    primaryStage.setScene(new Scene(new StackPane(label), 500, 300));
    primaryStage.show();
  }

  private void incrementLabel() {
    label.setText(String.format("%,d", count++));
  }
}