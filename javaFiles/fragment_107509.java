import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DynamicTextFields extends Application {

    private TextField lastTextField ;

    @Override
    public void start(Stage primaryStage) {
        lastTextField = new TextField();
        VBox vbox = new VBox(5, lastTextField);
        ChangeListener<String> textFieldListener = new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> obs, String oldValue, String newValue) {
                lastTextField.textProperty().removeListener(this);
                lastTextField = new TextField();
                lastTextField.textProperty().addListener(this);
                vbox.getChildren().add(lastTextField);
            }

        };
        lastTextField.textProperty().addListener(textFieldListener);

        Scene scene = new Scene(new ScrollPane(vbox), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}