import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

  private ToggleGroup toggleGroup;
  private ToggleButton lineBtn;

  private Group group;
  private Line currentLine;

  @Override
  public void start(Stage primaryStage) {
    toggleGroup = new ToggleGroup();
    lineBtn = new ToggleButton("Line");

    ToggleButton noneBtn = new ToggleButton("None");
    toggleGroup.getToggles().addAll(lineBtn, noneBtn);
    toggleGroup.selectToggle(noneBtn);

    group = new Group();

    BorderPane root = new BorderPane(new Pane(group), new ToolBar(lineBtn, noneBtn), null, null, null);
    root.getCenter().setOnMousePressed(this::handleMousePressed);
    root.getCenter().setOnMouseDragged(this::handleMouseDragged);
    root.getCenter().setOnMouseReleased(this::handleMouseReleased);

    primaryStage.setScene(new Scene(root, 800, 600));
    primaryStage.setTitle("Draw Shape Example");
    primaryStage.show();
  }

  private void handleMousePressed(MouseEvent event) {
    if (lineBtn.equals(toggleGroup.getSelectedToggle())
        && event.getButton() == MouseButton.PRIMARY) {
      currentLine = new Line(event.getX(), event.getY(), event.getX(), event.getY());
      group.getChildren().add(currentLine);
    }
  }

  private void handleMouseDragged(MouseEvent event) {
    if (currentLine != null) {
      currentLine.setEndX(event.getX());
      currentLine.setEndY(event.getY());
    }
  }

  private void handleMouseReleased(MouseEvent event) {
    if (currentLine != null 
        && currentLine.getStartX() == currentLine.getEndX()
        && currentLine.getStartY() == currentLine.getEndY()) {
      // The line has no length, remove it
      group.getChildren().remove(currentLine);
    }
    currentLine = null;
  }

}