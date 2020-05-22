import com.sun.javafx.scene.control.skin.TextFieldSkin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class GiveMeContext extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        TextField textField = new TextField();
        TextFieldSkin customContextSkin = new TextFieldSkin(textField) {
            @Override
            public void populateContextMenu(ContextMenu contextMenu) {
                super.populateContextMenu(contextMenu);
                contextMenu.getItems().add(0, new SeparatorMenuItem());
                contextMenu.getItems().add(0, new MenuItem("Register"));
            }
        };
        textField.setSkin(customContextSkin);

        stage.setScene(new Scene(textField));
        stage.show();
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}