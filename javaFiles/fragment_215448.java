import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 *
 * @author sedrick
 */
public final class ViewTwo extends StackPane{
    Label label = new Label();

    public ViewTwo() {
        label.setText("Scene Two!");
        getChildren().add(label);
    }   
}