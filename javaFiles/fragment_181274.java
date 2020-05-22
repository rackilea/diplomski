import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.Pane;

public class MyControl extends Control {
    @Override
    protected Skin<?> createDefaultSkin() {
        return new SkinBase<MyControl>(this) {
            {
                Pane pane = new Pane();
                pane.prefWidthProperty().bind(getSkinnable().prefWidthProperty());
                pane.prefHeightProperty().bind(getSkinnable().prefHeightProperty());
                pane.setStyle("-fx-background-color: red");
                getChildren().add(pane);
            }
        };
    }
}