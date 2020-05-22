import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class OpenSecretWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Type the secret password\nto open the secret window");
        label.setTooltip(new Tooltip("The secret password is \"secret\""));
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 400);

        StringBuilder typedText = new StringBuilder();
        scene.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            switch(e.getCharacter()) {
            case "\n":
            case "\r":
                typedText.delete(0, typedText.length());
                break ;
            default:
                typedText.append(e.getCharacter());
            }
            if ("secret".equals(typedText.toString())) {
                openSecretWindow(primaryStage);
                typedText.delete(0, typedText.length());
            }
        });

        // handle backspace and delete:
        scene.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
            if (e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.DELETE) {
                if (typedText.length() > 0) {
                    typedText.delete(typedText.length()-1, typedText.length());
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openSecretWindow(Stage owner) {
        Stage stage = new Stage();
        StackPane root = new StackPane(new Label("You have found\nthe secret window!"));
        Scene scene = new Scene(root, 300, 180);
        stage.setScene(scene);
        stage.initOwner(owner);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}