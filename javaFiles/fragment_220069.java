import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Conversation extends Application {

    private TextArea console ;
    private TextField input ;
    private BooleanProperty readyForInput ;

    private Timeline createTimeline(String[] messages) {
        Timeline timeline = new Timeline();
        Duration delayBetweenMessages = Duration.seconds(1);
        Duration frame = delayBetweenMessages ;
        for (String msg : messages) {
            timeline.getKeyFrames().add(new KeyFrame(frame, e -> console.appendText(msg+"\n")));
            frame = frame.add(delayBetweenMessages);
        }
        timeline.statusProperty().addListener((obs, oldStatus, newStatus) -> {
            readyForInput.set(newStatus != Animation.Status.RUNNING);
            if (newStatus != Animation.Status.RUNNING) {
                input.requestFocus();
            }
        });
        return timeline ;
    }

    @Override
    public void start(Stage primaryStage) {

        readyForInput = new SimpleBooleanProperty(false);

        console = new TextArea();
        console.setEditable(false);

        input = new TextField();
        input.disableProperty().bind(readyForInput.not());

        input.setOnAction(e -> {
            String inputText = input.getText();
            console.appendText("> "+inputText+"\n");
            input.clear();
            createTimeline(getMessages(inputText)).play();
        });

        BorderPane root = new BorderPane(console, input, null, null, null) ;
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        createTimeline(getMessages(null)).play();
    }

    private String[] getMessages(String input) {
        if (input == null || input.isEmpty()) {
            return new String[] {
                    "Goodday sir, how are you doing?",
                    "I'm fine thanks",
                    "What can I do for you?"
            };
        } else {
            // AI logic here...
            return new String[] { "Sure, I'll take care of it." };
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}