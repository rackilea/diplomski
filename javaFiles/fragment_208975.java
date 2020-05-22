import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FxmlTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI2.fxml"));
            Pane root = fxmlLoader.load();
            GUI2Controller controller = fxmlLoader.getController(); 

            //retrieve info from controller 
            SimpleHeatMap heatMap = controller.getHeatMap();
            Point2D[] events = controller.getEvents();

            //todo: use as needed 
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(null);
    }
}