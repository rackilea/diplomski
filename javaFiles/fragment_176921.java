package swapnode;

import java.util.Collection;
import java.util.Collections;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author reegan
 */
public class SwapNode extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(20);
        /* Thid Part Swap Children of Node */
        Pane pane = view();
        ObservableList<Node> workingCollection = FXCollections.observableArrayList(pane.getChildren());
        Collections.swap(workingCollection, 0, 1);
        pane.getChildren().setAll(workingCollection);

        root.getChildren().addAll(view(),pane);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public Pane view() {
        HBox pane = new HBox(10);
        Button button = new Button("Hello");
        TextField field = new TextField("World");
        pane.getChildren().addAll(button,field);
        return pane;
    }
}