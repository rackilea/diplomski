import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXPreloaderApp extends Application {

  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(createContent(), 300, 250);
    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public Parent createContent() {
    Button btn = new Button();
    btn.setText("Say 'Hello World'");
    btn.setOnAction((ActionEvent event) -> {
      System.out.println("Hello World!");
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);
    return root;
  }

  @Override
  public void init() throws Exception {
    // A time consuming task simulation
    final int max = 10;
    for (int i = 1; i <= max; i++) {
      notifyPreloader(new Preloader.ProgressNotification(((double) i) / max));
      Thread.sleep(500);
    }
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
}