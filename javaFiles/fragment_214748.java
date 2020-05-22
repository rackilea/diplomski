import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ReverseSequentialTransitionTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Rectangle rect = new Rectangle(50, 50, 250, 150);
        rect.setFill(Color.color(.5, .5, .1));
        pane.getChildren().add(rect);

        TranslateTransition ttForward = new TranslateTransition(Duration.seconds(1), rect);
        ttForward.setFromX(0);
        ttForward.setToX(400);
        TranslateTransition ttDown = new TranslateTransition(Duration.seconds(1), rect);
        ttDown.setFromY(0);
        ttDown.setToY(100);
        TranslateTransition ttBackward = new TranslateTransition(Duration.seconds(1), rect);
        ttBackward.setFromX(400);
        ttBackward.setToX(0);
        TranslateTransition ttUp = new TranslateTransition(Duration.seconds(1), rect);
        ttUp.setFromY(100);
        ttUp.setToY(0);

        List<Animation> transitions = Arrays.asList(ttForward, ttDown, ttBackward, ttUp);
        IntegerProperty nextTransitionIndex = new SimpleIntegerProperty();

        Button playButton = new Button("Play Forward");
        playButton.setOnAction(event -> {
            int index = nextTransitionIndex.get();
            Animation anim = transitions.get(index);
            anim.setOnFinished(evt -> nextTransitionIndex.set(index+1));
            anim.setRate(1);
            anim.play();
        });

        Button reverseButton = new Button("Play backward");
        reverseButton.setOnAction(event -> {
            int index = nextTransitionIndex.get()-1;
            Animation anim = transitions.get(index);
            anim.setOnFinished(evt -> nextTransitionIndex.set(index));
            anim.setRate(-1);
            anim.play();
        });

        // This is not really part of the answer to the current question, but the
        // next three statements just disable the buttons when appropriate.

        // This is a binding which is true if and only if any of the transitions are
        // currently running:

        BooleanBinding anyPlaying = createAnyPlayingBinding(transitions);

        // Disable playButton if we are at the end of the last transition, or if
        // any transitions are playing:

        playButton.disableProperty().bind(
                nextTransitionIndex.greaterThanOrEqualTo(transitions.size())
                .or(anyPlaying)
        );

        // Disable reverseButton if we are at the beginning of the first transition,
        // or if any transitions are currently playing:

        reverseButton.disableProperty().bind(
                nextTransitionIndex.lessThanOrEqualTo(0)
                .or(anyPlaying));

        HBox controls = new HBox(5);
        controls.setAlignment(Pos.CENTER);
        controls.getChildren().addAll(playButton, reverseButton);


        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(controls);

        primaryStage.setScene(new Scene(root, 800, 400));
        primaryStage.show();
    }

    private BooleanBinding createAnyPlayingBinding(List<Animation> transitions) {
        return new BooleanBinding() {
            { // Anonymous constructor
                // bind to the status properties of all the transitions
                // (i.e. mark this binding as invalid if any of the status properties change)
                transitions.stream()
                    .map(Animation::statusProperty)
                    .forEach(this::bind);
            }
            @Override
            protected boolean computeValue() {
                // return true if any of the transitions statuses are equal to RUNNING:
                return transitions.stream()
                    .anyMatch(anim -> anim.getStatus()==Status.RUNNING);
            }
        };

    }

    public static void main(String[] args) {
        launch(args);
    }
}