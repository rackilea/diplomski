import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestApp extends Application {

    private int index = 0;

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Change to Red");

        String allTexts[] = { "Change to Red", "Change to Blue", "Change to Green", "Change to Pink" };
        Color allColors[] = { Color.BLUE, Color.RED, Color.PINK, Color.GREEN };

        btn.setOnAction(e -> {

            index++;
            if(index >= allTexts.length ) {
                index = 0;
            }

            btn.setText(allTexts[index]);
            btn.setTextFill(allColors[index]);

        });

        VBox box = new VBox();
        box.getChildren().add(btn);

        primaryStage.setScene(new Scene(box));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}