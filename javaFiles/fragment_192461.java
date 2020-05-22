import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SwitchScene extends Application {

    public int page = 0;

    @Override
    public void start(Stage theStage) {

        new Controller(theStage);
        theStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Controller {

    private final View1 view1,  view2;
    private final Stage stage;

    private static final String[] images = {
            "https://findicons.com/files/icons/345/summer/128/cake.png",
            "http://icons.iconarchive.com/icons/atyourservice/service-categories/128/Sweets-icon.png"
    };

    Controller(Stage stage) {
        this.stage = stage;
        view1 = new View1(images[0]);
        view2 = new View1(images[1]);
        swapScenes();
    }

    void swapScenes(){

        new AnimationTimer() {

            int page = 2;
            @Override
            public void handle(long currentNanoTime){
                switch (page){
                    case 2:
                        page = 1;
                        stage.setScene(new Scene(new Group(view1)));
                        break;
                    case 1:
                        page = 2;
                        stage.setScene(new Scene(new Group(view2)));
                        break;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

class View1 extends ImageView {

    public View1(String imagePath) {
        super(imagePath);
    }
}