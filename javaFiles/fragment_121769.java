import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    private Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        Gui gui = new Gui();
        UpdateService service = new UpdateService(gui);
        service.startService();

        window.setTitle("Example");
        window.setResizable(false);
        window.setScene(gui.getScene());
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}