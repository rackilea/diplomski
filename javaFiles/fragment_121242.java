import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 *
 * @author Sedrick
 */
public class JavaFXApplication33 extends Application {

    @Override
    public void start(Stage primaryStage)
    {
        BorderPane bp = new BorderPane();
        HBox hbox = new HBox();
        bp.setBottom(hbox);

        Button btnLeft = new Button("Left");
        Label lblRight = new Label("Right");

        AnchorPane apLeft = new AnchorPane();
        HBox.setHgrow(apLeft, Priority.ALWAYS);//Make AnchorPane apLeft grow horizontally
        AnchorPane apRight = new AnchorPane();
        hbox.getChildren().add(apLeft);
        hbox.getChildren().add(apRight);

        apLeft.getChildren().add(btnLeft);
        apRight.getChildren().add(lblRight);

        Scene scene = new Scene(bp, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}