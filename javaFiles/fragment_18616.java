import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectHeightSlider extends Application
{
    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();

        Slider slider = new Slider();
        slider.setMin(10);
        slider.setMax(100);
        slider.setValue(50);
        slider.setOrientation(Orientation.VERTICAL);

        root.getChildren().add(slider);

        Rectangle r = new Rectangle();
        r.setWidth(100);
        r.heightProperty().bind(slider.valueProperty());
        root.getChildren().add(r);
        AnchorPane.setRightAnchor(r, 0.0);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}