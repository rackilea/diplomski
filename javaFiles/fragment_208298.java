import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ConsoleTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(new BorderPane(new Console()), 600, 600));
        primaryStage.show();
    }

    public static class Console extends TextArea {
        @Override
        public void replaceText(int start, int end, String text) {
            String current = getText();
            // only insert if no new lines after insert position:
            if (! current.substring(start).contains("\n")) {
                super.replaceText(start, end, text);
            }
        }
        @Override
        public void replaceSelection(String text) {
            String current = getText();
            int selectionStart = getSelection().getStart();
            if (! current.substring(selectionStart).contains("\n")) {
                super.replaceSelection(text);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}