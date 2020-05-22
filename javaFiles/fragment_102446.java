import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StackPaneTest extends Application {
  public void start(Stage stage) throws Exception {
    Pane root = new Pane();
    stage.setTitle("StackPane Test");
    stage.setScene(new Scene(root, 480, 360));
    stage.show();
    root.getChildren().add(new RectangleNode(100, 100));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
class RectangleNode extends Group {
  private VBox vbox;
  private Rectangle rect;
  public RectangleNode(double x, double y) {
    super();
    StackPane layout = new StackPane();
    layout.setAlignment(Pos.TOP_LEFT);

    Label label1 = new Label("Hello world");
    Label label2 = new Label("Hello JavaFX");

    vbox = new VBox(label1, label2);
    vbox.setPadding(new Insets(5));

    setTranslateX(x);
    setTranslateY(y);

    rect = new Rectangle();
    rect.setFill(Color.YELLOW);
    rect.setStrokeWidth(2);
    rect.setStroke(Color.BLACK);
    rect.widthProperty().bind(layout.widthProperty());
    rect.heightProperty().bind(layout.heightProperty());
    layout.getChildren().addAll(rect, vbox);
    getChildren().add(layout);
  }
}