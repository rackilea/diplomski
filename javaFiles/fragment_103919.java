import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Labels for AnchorPane's size
        Label apHeight = new Label();
        Label apWidth = new Label();

        // Labels for StackPane's size
        Label spHeight = new Label();
        Label spWidth = new Label();

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color : CORNSILK");
        anchorPane.setPrefSize(500, 500);

        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color : AQUA");
        stackPane.getChildren().add(new VBox(spWidth, spHeight));

        // Add labels and StackPane to AnchorPane
        VBox box = new VBox(apHeight, apWidth);
        anchorPane.getChildren().addAll(box, stackPane);

        // Set StackPane location in AnchorPane
        AnchorPane.setTopAnchor(stackPane, 200.0);
        AnchorPane.setLeftAnchor(stackPane, 200.0);

        // Listeners for updating the Label
        anchorPane.widthProperty().addListener((ov, oldValue, newValue) -> apWidth.setText("Width : " + String.valueOf(newValue)));
        anchorPane.heightProperty().addListener((ov, oldValue, newValue) -> apHeight.setText("Height : " + String.valueOf(newValue)));

        stackPane.widthProperty().addListener((ov, oldValue, newValue) -> spWidth.setText("W : " + String.valueOf(newValue)));
        stackPane.heightProperty().addListener((ov, oldValue, newValue) -> spHeight.setText("H : " + String.valueOf(newValue)));

        // Bind StackPane's Height and Width to that of AnchorPane's
        stackPane.prefHeightProperty().bind(anchorPane.heightProperty().divide(10));
        stackPane.prefWidthProperty().bind(anchorPane.widthProperty().divide(10));

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}