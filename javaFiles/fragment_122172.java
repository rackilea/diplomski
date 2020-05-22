import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;

public class ClipboardTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putHtml("<b>Some bold html</b>");
        clipboard.setContent(content);

        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}