import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClickThroughStackPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(400,400);
        canvas.setOnMouseClicked(e -> System.out.println("Mouse click: canvas"));
        HBox statusBar = new HBox(new Label("Status"));
        statusBar.setOnMouseClicked(e -> System.out.println("Mouse click: statusBar"));
        BorderPane borderPane = new BorderPane(canvas, statusBar, null, null, null);

        Button button = new Button("Click");
        button.setOnAction(e -> System.out.println("Button pressed"));
        StackPane stack = new StackPane(button);

        stack.setPickOnBounds(false);

        StackPane root = new StackPane(borderPane, stack);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}