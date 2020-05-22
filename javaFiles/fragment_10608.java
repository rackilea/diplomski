import javafx.application.Application;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.*;
import javafx.stage.Stage;

public class Main extends Application {
  private WebEngine myWebEngine;

  public void start(Stage stage) {
    stage.setTitle("Platinum v1");

    final TextField addressBar = new TextField();

    addressBar.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        myWebEngine.load(addressBar.getText());
      }
    });

    WebView myBrowser = new WebView();
    myWebEngine = myBrowser.getEngine();
    myWebEngine.getLoadWorker().exceptionProperty().addListener(new ChangeListener<Throwable>() {
      @Override public void changed(ObservableValue<? extends Throwable> observableValue, Throwable oldException, Throwable exception) {
        System.out.println("WebView encountered an exception loading a page: " + exception);
      }
    });

    VBox root = new VBox();
    root.getChildren().setAll(
        addressBar,
        myBrowser
    );
    stage.setScene(new Scene(root));
    stage.show();
  }

  public static void main(String[] args) { launch(args); }
}