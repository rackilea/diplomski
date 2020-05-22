import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BgrdService bgrdService = new BgrdService();
        bgrdService.setPeriod(Duration.millis(3000.0));
        bgrdService.start();

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Main.fxml"));
        MainController mainController = new MainController();
        loader.setController(mainController);
        Parent root = loader.load();

        mainController.valueProperty().bind(bgrdService.lastValueProperty());

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String... args) {
        launch(args);
    }
}