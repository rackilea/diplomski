import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/* Displays a button with it's text rotated 90 degrees to the left */
public class RotatedText extends Application {
    @Override public void start(Stage stage) {
        Button feedbackButton = createButtonWithRotatedText("Feedback Form");

        StackPane layout = new StackPane();
        layout.getChildren().setAll(feedbackButton);
        StackPane.setAlignment(feedbackButton, Pos.TOP_RIGHT);
        layout.setPrefSize(225, 275);
        layout.setStyle("-fx-background-color: lightcyan;");

        stage.setScene(new Scene(layout));
        stage.show();
    }

    private Button createButtonWithRotatedText(String text) {
        Button button = new Button();
        Label  label  = new Label(text);
        label.setRotate(-90);
        button.setGraphic(new Group(label));

        // in-line css just used for sample purposes,
        // usually you would apply a stylesheet.
        button.setStyle(
                "-fx-base: orange; " +
                "-fx-font-size: 30px; " +
                "-fx-text-background-color: whitesmoke;"
        );

        return button;
    }

    public static void main(String[] args) { launch(args); }
}