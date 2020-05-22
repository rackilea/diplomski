import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HighlightWholeWindow extends Application {

    @Override
    public void start(Stage primaryStage) {

        Region mask = createMask();
        ToggleButton highlightButton = new ToggleButton("Highlight");
        highlightButton.selectedProperty().addListener((obs, wasHighlighted, isNowHighlighted) -> {
            Pane root = (Pane)highlightButton.getScene().getRoot();
            if (isNowHighlighted) {
                root.getChildren().add(mask);
            } else {
                root.getChildren().remove(mask);
            }
        });

        VBox root = new VBox(highlightButton);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createMask() {
        Region mask = new Region();

        // in real life, use an external style sheet:
        mask.setStyle("-fx-background-color: #6495ed80;");

        mask.setManaged(false);
        mask.setMouseTransparent(true);
        mask.setLayoutX(0);
        mask.setLayoutY(0);

        ChangeListener<Bounds> boundsListener = (obs, oldBounds, newBounds) -> 
            mask.resizeRelocate(newBounds.getMinX(), newBounds.getMinY(),
                                newBounds.getWidth(), newBounds.getHeight());

        mask.parentProperty().addListener((obs, oldParent, newParent) -> {
            if (oldParent != null) {
                oldParent.boundsInLocalProperty().removeListener(boundsListener);
            }
            if (newParent != null) {
                Bounds newParentBounds = newParent.getBoundsInLocal() ;
                mask.resizeRelocate(newParentBounds.getMinX(), newParentBounds.getMinY(), 
                                    newParentBounds.getWidth(), newParentBounds.getHeight());
                newParent.boundsInLocalProperty().addListener(boundsListener);
            }
        });

        return mask ;
    }


    public static void main(String[] args) {
        launch(args);
    }
}