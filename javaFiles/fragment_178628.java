import javafx.application.Application;
import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomLabelDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello World");
        label.getStyleClass().add("custom-label");

        CheckBox errorCheckBox = new CheckBox("Error");
        PseudoClass errorState = PseudoClass.getPseudoClass("error");
        errorCheckBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> 
            label.pseudoClassStateChanged(errorState, isNowSelected));

        VBox root = new VBox(10, label, errorCheckBox);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 350, 75);
        scene.getStylesheets().add("custom-label.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}