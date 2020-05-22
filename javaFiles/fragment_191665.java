import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextHighlighter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextArea textArea = new TextArea(
                "The quick brown cat ran away with the spoon."
        );
        textArea.selectRange(4, 9);
        textArea.setWrapText(true);

        VBox layout = new VBox(10, new Button("Button"), textArea);
        final Scene scene = new Scene(layout);
        scene.getStylesheets().add(
                this.getClass().getResource("text-highlighter.css").toExternalForm()
        );
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}