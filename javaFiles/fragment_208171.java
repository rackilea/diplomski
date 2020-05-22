import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ToggleSetTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        ToggleSet<ToggleButton> toggleSet = new ToggleSet<>(5);
        GridPane grid = new GridPane() ;

        Spinner<Integer> maxSelectedSpinner = new Spinner<>(0, 20, 5);
        maxSelectedSpinner.getValueFactory().valueProperty().bindBidirectional(toggleSet.maximumSelectableProperty().asObject());

        grid.add(new HBox(2, new Label("Maximum selected"), maxSelectedSpinner), 0, 0, 2, 1);

        grid.addRow(1,  new Label("Selection"), new Label("Include in set"));

        for (int i = 1; i <= 20 ; i++) {
            RadioButton button = new RadioButton("Button "+i);
            CheckBox checkBox = new CheckBox();
            checkBox.selectedProperty().addListener((obs, wasChecked, isNowChecked) -> {
                if (isNowChecked) {
                    toggleSet.addToggle(button);
                } else {
                    toggleSet.removeToggle(button);
                }
            });
            checkBox.setSelected(true);
            grid.addRow(i + 1, button, checkBox);
        }
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(2);
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}