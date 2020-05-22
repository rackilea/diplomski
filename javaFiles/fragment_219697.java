import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxMain extends Application {

    private static final int VGAP = 20, HGAP = 30;

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        Button button1 = new Button("r1 c1");
        gridPane.addRow(1, button1, new Button("r1 c2"));
        gridPane.addRow(2, new Button("r2 c1"), new Button("r2 c2"));
        gridPane.setVgap(VGAP); gridPane.setHgap(HGAP);
        gridPane.setAlignment(Pos.CENTER);
        //apply row-height + vgap down translate (row height represented by
        //button height)
        gridPane.translateYProperty().bind(button1.heightProperty().add(VGAP));

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 200, 200);
        root.setCenter(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}