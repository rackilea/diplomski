import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FXCards extends Application {

    private class Card extends StackPane {

        // we declare a property here
        final BooleanProperty hideProperty = new SimpleBooleanProperty();

        public Card(boolean hide) {
            hideProperty.setValue(hide);

            Image cardDP = new Image("http://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/52_K_di_picche.jpg/174px-52_K_di_picche.jpg");
            ImageView iv = new ImageView(cardDP);
            getChildren().add(iv);

            Image cardBack = new Image("http://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Carta_Francese_retro_Blu.jpg/174px-Carta_Francese_retro_Blu.jpg");
            ImageView ivBack = new ImageView(cardBack);
            getChildren().add(ivBack);

            // binding to hideProperty
            // card back is visible if hide property is true
            ivBack.visibleProperty().bind(hideProperty);
            // card front is visible if property is false, see "not()" call
            iv.visibleProperty().bind(hideProperty.not());

            setOnMouseClicked((e)-> {
                // click on card to flip it
                hideProperty.setValue(!hideProperty.getValue());
            });
        }

    }


    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        root.getChildren().add(new Card(true));

        Scene scene = new Scene(root, 300, 500);
        primaryStage.setTitle("Click to Flip!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}