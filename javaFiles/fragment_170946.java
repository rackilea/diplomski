import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SSCCEForSO extends Application {

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchor= new AnchorPane();
        Group group= new Group();

        ImageView image= new ImageView();

        image.setImage(new Image("http://icons.iconarchive.com/icons/custom-icon-design/pretty-social-media-2/64/Google-wave-icon.png"));
        ImageView image2= new ImageView();
        image2.setImage(new Image("http://icons.iconarchive.com/icons/custom-icon-design/pretty-office-8/64/Pause-icon.png"));
        HBox hBox = new HBox();
        hBox.setPrefSize(200, 200);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-padding: 10;-fx-background-color: firebrick;-fx-background-radius: 5;");

        hBox.getChildren().add( image);
        hBox.getChildren().add( image2);

        group.getChildren().add(hBox);

        group.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Group!" + mouseEvent.getSource());
            }
        });

        image2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Image!" + mouseEvent.getSource());
                mouseEvent.consume();
            }
        });

        anchor.getChildren().add(group);
        Scene scene = new Scene(anchor, 800, 600);

        primaryStage.setScene( scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}