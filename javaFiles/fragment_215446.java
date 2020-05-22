import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final StackPane mainDisplay = new StackPane();
        final ViewOne viewOne = new ViewOne();
        final ViewTwo viewTwo = new ViewTwo();

        mainDisplay.getChildren().add(viewOne);//Load first view.

        Button btnStageOne = new Button("View One");
        Button btnStageTwo = new Button("View Two");

        btnStageOne.setOnAction((event) -> {
            if(!mainDisplay.getChildren().get(0).equals(viewOne))//If sceneone is not loaded, load it.
            {
                 mainDisplay.getChildren().set(0, viewOne);
            }

        });
        btnStageTwo.setOnAction((event) -> {
            if(!mainDisplay.getChildren().get(0).equals(viewTwo))//If scenetwo is not loaded, load it.
            {
                mainDisplay.getChildren().set(0, viewTwo);
            }
        });

        HBox hbButtonPanel = new HBox(btnStageOne, btnStageTwo);
        VBox root = new VBox(mainDisplay, hbButtonPanel);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hello World!");        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}