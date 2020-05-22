import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.stage.Stage;


public class FXLine extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Pane pane = new Pane();
        Line redLine = LineBuilder.create()
            .startX(296)
            .startY(128)
            .endX(401)
            .endY(233)
            .fill(Color.RED)
            .strokeWidth(10.0f)
            .build();
        pane.getChildren().add(redLine);
        stage.setScene(new Scene(pane, 425, 275));
        stage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}