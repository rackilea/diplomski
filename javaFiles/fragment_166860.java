import com.javafx.experiments.scenicview.ScenicView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.*;
import javafx.stage.*;

public class HtmlEditorInBorderPane extends Application {
  public static void main(String[] args) { launch(args); }
  @Override public void start(final Stage stage) throws IOException {
    // option pane.
    VBox optionPane = new VBox(10);
    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(new Menu("School"), new Menu("Social"), new Menu("Network"));
    TreeItem<String> root = new TreeItem<>("Private Notes");
    root.setExpanded(false);
    root.getChildren().addAll(new TreeItem<>("Layout"), new TreeItem<>("is not"), new TreeItem<>("easy"));
    TreeView<String> notes = new TreeView<>(root);
    optionPane.getChildren().addAll(menuBar, new Label("Kaiser Notes"), notes);
    optionPane.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");

    // editor pane.
    HTMLEditor editor = new HTMLEditor();
    VBox editorBox = new VBox(10);
    TextField textField = new TextField();
    editorBox.getChildren().addAll(textField, editor);
    editorBox.setStyle("-fx-background-color: mistyrose; -fx-padding: 10;");
    editor.setHtmlText(getSampleText());

    // option layout constraints
    VBox.setVgrow(notes, Priority.ALWAYS);

    // editor layout constraints
    textField.setMinHeight(Control.USE_PREF_SIZE); // stop the textfield from getting squashed when the scene is sized small.
    VBox.setVgrow(editor, Priority.ALWAYS);        // tells the editor to fill available vertical space.
    editorBox.setMinSize(0, 0);                    // stops the editor from overflowing it's bounds in a BorderPane.

    // layout the scene.
    BorderPane layout = new BorderPane();
    layout.setLeft(optionPane);
    layout.setCenter(editorBox);
    stage.setScene(new Scene(layout));
    stage.show();

    // addition of static layout grow constraints for the htmleditor embedded webview.
    WebView webview = (WebView) editor.lookup("WebView");
    GridPane.setHgrow(webview, Priority.ALWAYS);  // allow the webview to grow beyond it's preferred width of 800.
    GridPane.setVgrow(webview, Priority.ALWAYS);  // allow the webview to grow beyond it's preferred height of 600.
  }

  // get some dummy lorem ipsum sample text.
  private String getSampleText() throws IOException {
    StringBuilder builder = new StringBuilder();
    try (BufferedReader in = new BufferedReader(new InputStreamReader(new URL("http://www.lorem-ipsum-text.com/").openStream()))) {
      String string;
      while ((string = in.readLine()) != null) {
        builder.append(string);
      }
    }
    return builder.toString();
  }
}