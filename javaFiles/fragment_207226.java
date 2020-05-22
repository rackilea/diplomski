import static java.util.stream.Collectors.toList;

import java.util.Random;
import java.util.stream.IntStream;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class SynchronizedTextAreaScrolling extends Application {

    private static final Random RNG = new Random();

    @Override
    public void start(Stage primaryStage) {
        TabPane tabs = new TabPane();
        Tab tab = new Tab("Tab 1");
        tab.setContent(createTextAreas());
        tabs.getTabs().add(tab);

        Button addTab = new Button("New");
        addTab.setOnAction(e -> {
            Tab newTab = new Tab("Tab "+(tabs.getTabs().size()+1));
            newTab.setContent(createTextAreas());
            tabs.getTabs().add(newTab);
            tabs.getSelectionModel().select(newTab);
        });

        BorderPane root = new BorderPane(tabs, null, null, addTab, null);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private HBox createTextAreas() {
        TextArea lineNumbers = new TextArea();
        int numLines = RNG.nextInt(20) + 20 ;
        lineNumbers.setText(String.join("\n", IntStream.rangeClosed(1, numLines).mapToObj(Integer::toString).collect(toList())));

        TextArea text = new TextArea();
        text.setText(String.join("\n", IntStream.rangeClosed(1, numLines).mapToObj(i -> "Line "+i).collect(toList())));

        lineNumbers.setMinWidth(40);
        lineNumbers.setPrefWidth(60);

        HBox.setHgrow(lineNumbers, Priority.NEVER);
        HBox.setHgrow(text, Priority.ALWAYS);

        // An AnimationTimer, whose handle(...) method will be invoked once
        // on each frame pulse (i.e. each rendering of the scene graph)
        AnimationTimer timer = new AnimationTimer() {

            // count number of frames rendered since the timer was started:
            private int frameCount = 0 ;

            @Override
            public void handle(long now) {
                frameCount++ ;

                // wait for the second frame. This should ensure that
                // the text areas have been rendered to the scene and so
                // they have had CSS applied. This allows us to use
                // lookups on them
                if (frameCount >= 2) {
                    ScrollBar sb1 = (ScrollBar) lineNumbers.lookup(".scroll-bar:vertical");
                    ScrollBar sb2 = (ScrollBar) text.lookup(".scroll-bar:vertical");
                    sb1.valueProperty().bindBidirectional(sb2.valueProperty());

                    // this animation timer is no longer needed, so stop it:
                    stop();
                }
            }
        };
        timer.start();

        return new HBox(lineNumbers, text);
    }

    public static void main(String[] args) {
        launch(args);
    }
}