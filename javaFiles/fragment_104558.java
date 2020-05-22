import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TextAnimation extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage stage) {

    Label label = new Label("Text Size Animation");
    Pane root = new Pane(label);
    root.setPrefSize(1100, 300);
    Scene scene = new Scene(root);

    // transit text size from 10 to 100 during 5 seconds
    TextSizeTransition trans = new TextSizeTransition(label, 10, 100,Duration.millis(5000));

    stage.setScene(scene);
    stage.show();

    trans.play();
  }
}