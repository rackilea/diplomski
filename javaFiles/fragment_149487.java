import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// displays the width in pixels of an arbitrary piece of text.
public class MeasureText extends Application {
  public static void main(String[] args) { launch(args); }
  @Override public void start(Stage stage) throws Exception {
    final Text text = new Text("XYZZY");
    new Scene(new Group(text));

    // java 7 => 
    //    text.snapshot(null, null);
    // java 8 =>
    text.applyCss(); 

    final double width = text.getLayoutBounds().getWidth();

    stage.setScene(new Scene(new Label(Double.toString(width))));
    stage.show();
  }
}