import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class ReflectedPaneTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scale scale = new Scale();
        scale.setX(1);
        scale.setY(-1);

        scale.pivotYProperty().bind(Bindings.createDoubleBinding(() -> 
            pane.getBoundsInLocal().getMinY() + pane.getBoundsInLocal().getHeight() /2, 
            pane.boundsInLocalProperty()));
        pane.getTransforms().add(scale);

        pane.setOnMouseClicked(e -> 
            System.out.printf("Mouse clicked at [%.1f, %.1f]%n", e.getX(), e.getY()));

        primaryStage.setScene(new Scene(pane, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}