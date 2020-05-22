import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Test");

        VBox content = new VBox(5);
        ScrollPane scroller = new ScrollPane(content);
        scroller.setFitToWidth(true);

        Pane root = new Pane();     
        initRects(root);

        content.getChildren().add(root);

        Scene scene = new Scene(new BorderPane(scroller, null, null, null, null), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    void initRects(Pane root){
         DrawRect(root, 0);
         DrawRect(root, 100);
         DrawRect(root, 200);
         DrawRect(root, 300);
    }

    void DrawRect(Pane root, double y){
        Rectangle rect = new Rectangle(50, 50 + y, 900, 50);
        rect.setFill(Color.DODGERBLUE);
        root.getChildren().add(rect);
    }
}