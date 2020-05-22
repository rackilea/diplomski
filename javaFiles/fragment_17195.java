import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.*;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.stage.Stage;

public class TransparentPngSample extends Application {  
  public static final String IMAGE_LOC = "http://i.imgur.com/byY8whh.png";

  @Override public void start(Stage stage) {
    Pane layout = createSceneContent();
    stage.setScene(new Scene(layout));
    stage.show();

    System.out.println("Layout SnapToPixel: " + layout.snapToPixelProperty().get());
  }

  private Pane createSceneContent() {
    final Image cloudImage = new Image(IMAGE_LOC);
    final ImageView fuzzyCloud = new ImageView(cloudImage);
    final CenteredRegion crispCloud = new CenteredRegion(new ImageView(cloudImage));

    GridPane layout = new GridPane();
    layout.setHgap(10);
    layout.setVgap(10);
    layout.addRow(0, fuzzyCloud, crispCloud);
    layout.setAlignment(Pos.CENTER);
    layout.setStyle("-fx-padding: 10px; -fx-background-color: slategrey;");

    fuzzyCloud.boundsInParentProperty().addListener(new BoundsReporter("fuzzy"));
    crispCloud.boundsInParentProperty().addListener(new BoundsReporter("crisp"));

    return layout;
  }

  class CenteredRegion extends Region {
    private Node content;

    CenteredRegion(Node content) {
      this.content = content;
      getChildren().add(content);
    }

    @Override protected void layoutChildren() {
      content.relocate(
        Math.round(getWidth()  / 2 - content.prefWidth(USE_PREF_SIZE)  / 2), 
        Math.round(getHeight() / 2 - content.prefHeight(USE_PREF_SIZE) / 2)
      );

      System.out.println("crisp content relocated to: " +
        getLayoutX() + "," + getLayoutY()
      );
    }

    public Node getContent() {
      return content;
    }
  }

  class BoundsReporter implements ChangeListener<Bounds> {
    final String logPrefix;

    BoundsReporter(String logPrefix) {
      this.logPrefix = logPrefix;
    }

    @Override public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds newBounds) {
      System.out.println(logPrefix + ": " + 
        "New Bounds: " + newBounds
      );
      double xDisplacement = newBounds.getMinX() - Math.floor(newBounds.getMinX());
      double yDisplacement = newBounds.getMinY() - Math.floor(newBounds.getMinY());
      System.out.println(logPrefix + ": " + 
        "xDisplacement: " + xDisplacement + ", " + 
        "yDisplacement: " + yDisplacement
      );
    }
  }          

  public static void main(String[] args) { launch(args); }
}