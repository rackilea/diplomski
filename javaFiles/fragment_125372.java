import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewHeightTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        String initialURL = "http://stackoverflow.com/questions/23170817/javafx-simpleswingbrowser-auto-fit-web-page" ;
        BorderPane root = new BorderPane();
        TextField locationBar = new TextField(initialURL);
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        locationBar.setOnAction(event -> engine.load(makeUrl(locationBar.getText())));

        root.setTop(locationBar);
        root.setCenter(webView);

            // Get full width and height of page when it's loaded:

        engine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
           if (newState == Worker.State.SUCCEEDED) {
               int width = (Integer) engine.executeScript("document.body.scrollWidth");
               int height = (Integer) engine.executeScript("document.body.scrollHeight");
               System.out.printf("[%d, %d]%n", width, height);
           }
        }); 

        engine.load(initialURL);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String makeUrl(String text) {
        if (text.contains("://")) {
            return text ;
        } else {
            return "http://"+text ;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}