import javafx.beans.binding.Bindings;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Region;
import javafx.scene.transform.Rotate;

public static void pointArrowUp(TitledPane pane) {
    Region arrow = (Region) pane.lookup(".arrow");

    Rotate rotate = new Rotate();
    rotate.pivotXProperty().bind(arrow.widthProperty().divide(2.0));
    rotate.pivotYProperty().bind(arrow.heightProperty().divide(2.0));
    rotate.angleProperty().bind(
            Bindings.when(pane.expandedProperty())
                    .then(-180.0)
                    .otherwise(90.0)
    );

    arrow.getTransforms().add(rotate);
    pane.setAnimated(false);
}