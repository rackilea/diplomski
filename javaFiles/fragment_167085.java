import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    private Stage primaryStage;
    private Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {

            this.primaryStage = primaryStage;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/LoginUI.fxml"));
            root = loader.load();
            ControllerLogin controller = loader.getController();
            controller.setMain(this);

            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startApp() throws Exception{

        try {
            root = FXMLLoader.load(getClass().getResource("/financeApp/UI.fxml"));
            Scene scene = new Scene(root, 1022, 593);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}