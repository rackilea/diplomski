import java.util.Set;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * ScrollBar bug in JavaFX 8 WebView?
 *
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
public class WebViewAndItsScrollBars extends Application {

    @Override
    public void start(Stage primaryStage) {

        // create webview and load content
        WebView view = new WebView();

        view.getEngine().load(
                "https://docs.oracle.com/javase/8/javafx/"
                + "api/javafx/scene/control/ScrollBar.html");

        // change scrollbar value, i.e., thumb position via button
        Button btn = new Button();
        btn.setText("Move ScrollBar");
        btn.setOnAction((ActionEvent event) -> {

            int value = 2000;
            System.out.println(">> current value: " + getVScrollValue(view));
            System.out.println(">> setting scrollbar value to " + value);
            scrollTo(view, 0, value);

        });

        // create root layout
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(view);
        root.getChildren().add(btn);

        // setup and show stage
        Scene scene = new Scene(root, 1024, 600);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Scrolls to the specified position.
     * @param view web view that shall be scrolled
     * @param x horizontal scroll value
     * @param y vertical scroll value
     */
    public void scrollTo(WebView view, int x, int y) {
        view.getEngine().executeScript("window.scrollTo(" + x + ", " + y + ")");
    }

    /**
     * Returns the vertical scroll value, i.e. thumb position.
     * This is equivalent to {@link javafx.scene.control.ScrollBar#getValue().
     * @param view
     * @return vertical scroll value
     */
    public int getVScrollValue(WebView view) {
        return (Integer) view.getEngine().executeScript("document.body.scrollTop");
    }

    /**
     * Returns the horizontal scroll value, i.e. thumb position.
     * This is equivalent to {@link javafx.scene.control.ScrollBar#getValue()}.
     * @param view
     * @return horizontal scroll value
     */
    public int getHScrollValue(WebView view) {
        return (Integer) view.getEngine().executeScript("document.body.scrollLeft");
    }

    /**
     * Returns the maximum vertical scroll value. 
     * This is equivalent to {@link javafx.scene.control.ScrollBar#getMax()}.
     * @param view 
     * @return vertical scroll max
     */
    public int getVScrollMax(WebView view) {
        return (Integer) view.getEngine().executeScript("document.body.scrollWidth");
    }

    /**
     * Returns the maximum horizontal scroll value. 
     * This is equivalent to {@link javafx.scene.control.ScrollBar#getMax()}.
     * @param view 
     * @return horizontal scroll max
     */
    public int getHScrollMax(WebView view) {
        return (Integer) view.getEngine().executeScript("document.body.scrollHeight");
    }
}