import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/** @see http://stackoverflow.com/a/33824164/230513 */
public class WebViewPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://www.example.com");
        root.getChildren().add(webView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("WebView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}