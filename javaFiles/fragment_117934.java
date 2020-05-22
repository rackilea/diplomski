import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FxTemp extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image("file:///home/username/Desktop/test.png");
        primaryStage.setTitle("animated");
        ImageView imageView = new ImageView(image);
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, evt->{
            System.out.println("click");
            Image imager = new Image("file:///home/username/Desktop/test.png");
            imageView.setImage(imager);
        });
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        primaryStage.setScene(new Scene(root, 512, 512));
        primaryStage.show();
    }
}