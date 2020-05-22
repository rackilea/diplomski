import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @see http://stackoverflow.com/a/37839898/230513
 */
public class Test extends Application {

    private final HostServices services = this.getHostServices();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test");
        Button button = new Button("Example");
        button.setOnAction((ActionEvent e) -> {
            services.showDocument("http://example.com/");
        });
        StackPane root = new StackPane();
        root.getChildren().add(button);
        Scene scene = new Scene(root, 320, 240);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}