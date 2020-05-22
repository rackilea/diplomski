import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Test extends Application{

    private static int counter =0;
    private ImageView iv;
    private Image[] images;
    private final String[] urls = {
            "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/lg/57/tropical-fish_1f420.png",
            "https://www.shareicon.net/data/128x128/2015/03/28/14104_animal_256x256.png",
            "https://cdn1.iconfinder.com/data/icons/DarkGlass_Reworked/128x128/apps/gnome-fish.png",
            "http://www.iconsalot.com/asset/icons/freepik/pet-shop-13/128/010-fish-2-icon.png"
    };

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        images = new Image[urls.length];
        for(int i=0; i< urls.length; i++) {
            images[i] = new Image(urls[i]);
        }

        iv = new ImageView(images[counter++]);
        Button swapImage = new Button("Swap Image");
        swapImage.setOnAction(e->swapImage());
        BorderPane root = new BorderPane(iv);
        root.setBottom(swapImage);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    private void swapImage() {
        counter = counter +1 >= images.length ? 0 : counter;
        iv.setImage(images[counter++]);
    }

    public static void main(String[] args)  {
        Application.launch(args);
    }
}