import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class PolygonTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Polygon.fxml"));
        loader.getNamespace().put("points", Arrays.asList(100.0,0.0,100.0,100.0,0.0,0.0));
        Polygon poly = loader.load();
        Scene scene = new Scene(new Group(poly), 450, 175);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}