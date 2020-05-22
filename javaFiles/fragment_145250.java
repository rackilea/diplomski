import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImgVwTst extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Image img = new Image("url");
        ImageView imgVw = new ImageView(img);
        root.setCenter(imgVw);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Button nextImageButton = new Button("next");
        nextImageButton.setOnAction(e -> {Image img2 = new Image("url");
                                          imgVw.setImage(img2);
                                          primaryStage.sizeToScene();});
        hBox.getChildren().add(nextImageButton);
        root.setBottom(hBox);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}