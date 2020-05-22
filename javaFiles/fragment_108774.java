import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class JavaFXApplication1 extends Application {

  @Override
  public void start(Stage primaryStage) {
    HTMLEditor editor = new HTMLEditor();
    editor.setHtmlText("<html>"
            + "<head>"
            + "<title>A Test</title>"
            + "</head>"
            + "<body>This is just a Test</body>"
            + "</html>");

    TextArea area = new TextArea();
    area.setText(editor.getHtmlText());
    editor.addEventHandler(EventType.ROOT, (Event event) -> {
      area.setText(editor.getHtmlText());
    });

    VBox root = new VBox();
    VBox.setVgrow(area, Priority.ALWAYS);
    root.getChildren().addAll(editor, area);

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
}