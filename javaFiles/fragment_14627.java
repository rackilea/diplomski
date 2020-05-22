import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class ViewOptionsController {

    @FXML
    private CheckBox optionalColumnVisibleCheckBox ;

    public BooleanProperty optionalColumnVisibleProperty() {
        return optionalColumnVisibleCheckBox.selectedProperty();
    }

    public final boolean isOptionalColumnVisible() {
        return optionalColumnVisibleProperty().get();
    }

    public final void setOptionalColumnVisible(boolean optionalColumnVisible) {
        optionalColumnVisibleProperty().set(optionalColumnVisible);
    }

    @FXML
    private void close() {
        optionalColumnVisibleCheckBox.getScene().getWindow().hide();
    }
}