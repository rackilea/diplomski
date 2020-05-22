import java.util.concurrent.Callable;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AutosizingTextArea extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setMinHeight(24);
        textArea.setWrapText(true);
        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        // This code can only be executed after the window is shown:

        // Perform a lookup for an element with a css class of "text"
        // This will give the Node that actually renders the text inside the
        // TextArea
        Node text = textArea.lookup(".text");
        // Bind the preferred height of the text area to the actual height of the text
        // This will make the text area the height of the text, plus some padding
        // of 20 pixels, as long as that height is between the text area's minHeight
        // and maxHeight. The minHeight we set to 24 pixels, the max height will be
        // the height of its parent (usually).
        textArea.prefHeightProperty().bind(Bindings.createDoubleBinding(new Callable<Double>(){
            @Override
            public Double call() throws Exception {
                return text.getBoundsInLocal().getHeight();
            }
        }, text.boundsInLocalProperty()).add(20));

    }

    public static void main(String[] args) {
        launch(args);
    }
}