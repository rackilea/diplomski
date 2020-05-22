import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ImageTest extends Application {

    public static void main(String[] args) {
        launch(args) ;
    }

    @Override
    public void start(Stage primaryStage) {
        String[] urls = new String[]{
                "https://www.wbkidsgo.com/Portals/1/Content/Hero/HeroBugsCarrot/Source/Default/WB_LT_HeroImage_Bugs_v1.png",
                "https://www.wbkidsgo.com/Portalss/1/Content/Hero/HeroBugsCarrot/Source/Default/WB_LT_HeroImage_Bugs_v1.png"
        } ;

        for (String url : urls) {
            Image image = new Image(url);
            if (image.isError()) {
                System.out.println("Error loading image from "+url);
                // if you need more details
                // image.getException().printStackTrace();
            } else {
                System.out.println("Successfully loaded image from " + url);
            }
        }
        Platform.exit();
    }

}