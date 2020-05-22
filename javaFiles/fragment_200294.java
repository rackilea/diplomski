import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class CSS3Test extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();
        WebView view = new WebView();

        WebEngine engine = view.getEngine();
        engine.load("http://css3test.com/");
        pane.getChildren().add(view);

        Scene scene = new Scene(pane, 960, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        Application.launch(args);
    }
}