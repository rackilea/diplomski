import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Click Me");
        TextField textField = new TextField();

        button.addEventHandler(KeyEvent.KEY_PRESSED, e -> System.out.println("Key press on button"));
        button.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> System.out.println("Mouse press on button"));
        button.addEventHandler(ActionEvent.ACTION, e -> System.out.println("Action on button"));
        textField.addEventHandler(ActionEvent.ACTION, e -> System.out.println("Action on text field"));

        VBox root = new VBox(10, textField, button);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(24));
        primaryStage.setScene( new Scene(root) );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}