import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TextFlowExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text1 = new Text("First Text\n");
        text1.setStyle("-fx-font-size: 20; -fx-fill: darkred;");
        Text text2 = new Text("\nSecond Text");
        text2.setStyle("-fx-font-size: 30; -fx-fill: goldenrod;");
        TextFlow textFlow = new TextFlow(text1, text2);
        primaryStage.setScene(new Scene(textFlow, 200, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}