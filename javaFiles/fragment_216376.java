import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class GiveMeContext extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem register = new MenuItem("Register");
        contextMenu.getItems().add(register);

        TextField textField = new TextField();
        textField.setContextMenu(contextMenu);

        stage.setScene(new Scene(textField));
        stage.show();
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}