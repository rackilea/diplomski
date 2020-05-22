import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
public class NashornTest extends Application{

@Override

public void start(Stage stage)
{

    //create an embeded web browser
    WebView browser = new WebView();

    browser.getEngine().getLoadWorker()
            .stateProperty()
            .addListener((obs, old, neww) ->
            {
                if (neww == Worker.State.SUCCEEDED)
                {
                    // Let JavaScript make calls to adder object,
                    //so we need to inject an [Adder] object into the JS code
                    JSObject bridge = (JSObject) browser.getEngine()
                            .executeScript("window");
                    bridge.setMember("adder", new Adder());
                }
            });
    //load the html page
    browser.getEngine().load(NashornTest.class.getResource("index.xhtml").toString());
    VBox box = new VBox(browser);

    Scene scene = new Scene(box);
    stage.setScene(scene);
    stage.show();
}

public static void main(String[] args)
{
    launch(args);
}}