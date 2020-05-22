import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    private Button[] btns = new Button[10];

    @Override
    public void start(Stage primaryStage) {

        initBtnsArray();
        Group root = new Group();

        root.getChildren().add(getGrid());
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Hello Controller-Array-World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private Pane getGrid() {
        int i = 0;
        GridPane gridPane = new GridPane();
        for(Button b : btns) {
            // do something with your button
            // maybe add an EventListener or something
            gridPane.add(b, i*(i+(int)b.getWidth()), 0);
            i++;
        }
        return gridPane;
    }

    private void initBtnsArray() {
        for(int i = 0; i < btns.length; i++) {
            btns[i] = new Button("Button-"+i);
        }
    }
}