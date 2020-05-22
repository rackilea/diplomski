import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {   
        VBox root = new VBox(new DatePicker());

        // Problem shows up when using USE_COMPUTED_SIZE (the default) as well
        root.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        root.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}