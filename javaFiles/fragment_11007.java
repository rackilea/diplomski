import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloWorld extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage stage) {
    stage.setScene(new Scene(new Label("Hello World")));
    stage.show();
  }
}