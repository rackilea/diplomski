import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class scratch_1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        Label lblTitle = new Label("Gib die Basis und die Zahl ein!");
        root.getChildren().add(lblTitle);

        // The input TextField
        TextField txtInput = new TextField();
        root.getChildren().add(txtInput);

        // HBox to hold our three columns
        HBox hBoxSelections = new HBox(20);
        hBoxSelections.setAlignment(Pos.CENTER);

        // Use a GridPane for our RadioButton grid
        GridPane gridSelections = new GridPane();
        gridSelections.setAlignment(Pos.CENTER);
        gridSelections.setHgap(10);
        gridSelections.setVgap(5);

        // Our ToggleGroup to which all RadioButtons will belong
        ToggleGroup groupSelections = new ToggleGroup();

        // We need 11 rows of 3 RadioButtons, let's use a couple of for loops to populate the GridPane
        int counter = 2;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                RadioButton radioButton = new RadioButton("" + counter);
                radioButton.setToggleGroup(groupSelections);

                gridSelections.add(radioButton, j, i);
                counter++;
            }
        }

        // Let's add the GridPane to our root layout
        root.getChildren().add(gridSelections);

        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}