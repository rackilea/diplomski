import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollingGrid extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        String border = "-fx-border-color:red;";
        Text title = new Text("Machin");

        GridPane appleGrid = new GridPane();
        appleGrid.setMinSize(80, 5);
        appleGrid.setStyle(border);
        appleGrid.add(title, 0, 0);

        for (int i = 1; i <= 15; i++) {
            appleGrid.add(new Text("Apple"), 0, i);
        }

        ScrollPane scrollPane = new ScrollPane(appleGrid);
        scrollPane.setPrefViewportWidth(80);
        scrollPane.setPrefViewportHeight(80);
        scrollPane.setMaxSize(ScrollPane.USE_PREF_SIZE, ScrollPane.USE_PREF_SIZE);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new Label("Header"));
        borderPane.setCenter(scrollPane);
        borderPane.setBottom(new Label("Bottom"));

        primaryStage.setScene(new Scene(borderPane, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}