import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class MainController {

    @FXML
    private ToggleGroup myToggleGroup;

    @FXML
    private GridPane grid;

    @FXML
    private Label label;

    private StringProperty valueProperty = new SimpleStringProperty("");

    @FXML
    void initialize() {
        valueProperty.addListener((observable, oldValue, newValue) -> {
            updateUi();
        });
        myToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            updateUi();
        });
    }

    private void updateUi() {
        String displayValue = getValue();
        label.setText(displayValue);
        int index = myToggleGroup.getToggles().indexOf(myToggleGroup.getSelectedToggle());
        if( index >= 0 ) {
            TextField textField = (TextField) grid.getChildren().get(index);
            textField.setText(displayValue);
        }
    }

    public String getValue() { return valueProperty.get(); }
    public void setValue(String value) { valueProperty.set(value); }
    public StringProperty valueProperty() { return this.valueProperty; }
}