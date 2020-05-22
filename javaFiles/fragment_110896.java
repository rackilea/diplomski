import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainController {

  @FXML
  private ImageView imageView;
  private AnimationTimer imageTimer;

  public void displayOtherWindow() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Other.fxml"));
    Scene scene = new Scene(loader.load(), 500, 300);

    Stage stage = new Stage();
    stage.setScene(scene);
    stage.setTitle("Other Window");
    stage.setResizable(false);
    stage.show();

    ((OtherController) loader.getController()).startAnimation();

    imageTimer = new ScreenshotsAnimationTimer(scene);
    imageTimer.start();
  }

  private class ScreenshotsAnimationTimer extends AnimationTimer {

    private final Scene scene;

    private ScreenshotsAnimationTimer(Scene scene) {
      this.scene = scene;
    }

    @Override
    public void handle(long now) {
      imageView.setImage(scene.snapshot(null));
    }

  }
}