import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 *
 * @author sedrick
 */
public final class ViewOne extends StackPane{
    Label label = new Label();

    public ViewOne() {
        label.setText("Scene One!");
        getChildren().add(label);
    }   
}