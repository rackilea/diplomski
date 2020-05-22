import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Gui {

    private Scene scene;
    private HBox layout = new HBox();
    private Label result = new Label("TEST");

    public Gui() {
        layout.getChildren().addAll(result);
        scene = new Scene(layout, 1280, 720);
    }

    public Scene getScene() {
        return scene ;
    }

    public void setResult(double res){
        result.setText("" + res);
    }
}