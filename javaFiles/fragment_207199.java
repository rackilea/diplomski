import javafx.application.Application;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class TheMachineThatGoesPing extends Application {
  private static final String HOME_LOC = 
    "http://en.wikiquote.org/wiki/Monty_Python's_The_Meaning_of_Life";

  private WebView   webView;
  private AudioClip ping;

  public static void main(String[] args) { Application.launch(TheMachineThatGoesPing.class); }

  @Override
  public void init() throws Exception {
    ping = new AudioClip("http://soundbible.com/grab.php?id=1815&type=wav");
  }

  @Override public void start(Stage stage) throws Exception {
    webView = new WebView();
    webView.setPrefWidth(1000);

    final TextField location = new TextField();
    location.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        if (!location.getText().startsWith("http")) {
          location.setText("http://" + location.getText());
        }
        webView.getEngine().load(location.getText());
      }
    });

    webView.getEngine().locationProperty().addListener(new ChangeListener<String>() {
      @Override public void changed(ObservableValue<? extends String> observable, String oldLocation, String newLocation) {
        location.setText(newLocation);
        ping.play();
      }
    });

    webView.getEngine().load(HOME_LOC);

    VBox layout = new VBox(10);
    layout.setStyle("-fx-padding: 10; -fx-background-color: cornsilk;");
    layout.getChildren().setAll(
      location,
      webView
    );

    stage.setTitle("The machine that goes 'ping!'");
    stage.setScene(new Scene(layout));
    stage.show();
  }
}