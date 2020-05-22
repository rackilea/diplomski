import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane root = new BorderPane(new Label("Hello, World!"));

    HBox leftBox = new HBox(new Button("Left Button"));
    leftBox.setAlignment(Pos.CENTER_LEFT);
    HBox.setHgrow(leftBox, Priority.ALWAYS);

    HBox rightBox = new HBox(new Button("Right Button"));
    rightBox.setAlignment(Pos.CENTER_RIGHT);
    HBox.setHgrow(rightBox, Priority.ALWAYS);

    HBox bottom = new HBox(leftBox, rightBox);
    bottom.setPadding(new Insets(10));
    root.setBottom(bottom);

    primaryStage.setScene(new Scene(root, 600, 400));
    primaryStage.show();
  }

}