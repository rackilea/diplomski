import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FxTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        String imagePath = "https://png.pngtree.com/png-clipart/20190118/ourmid/"
                          + "pngtree-hand-drawn-spaceship-grey-spaceship-alien-spaceship-blue"
                          + "-spaceship-border-png-image_450067.jpg";
        Image image =  new Image(imagePath);
        Rectangle rec = new Rectangle(0, 0, 50+image.getWidth(), 50+image.getHeight());
        rec.setFill(Color.AQUA);

        StackPane root = new StackPane();
        root.getChildren().add(rec);
        root.getChildren().add(new ImageView(image));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(null);
    }
}