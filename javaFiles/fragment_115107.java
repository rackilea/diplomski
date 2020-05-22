import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class PersonUnemployedValueFactory implements Callback, ObservableValue> {
    @Override
    public ObservableValue call(TableColumn.CellDataFeatures param) {
        Person person = param.getValue();
        CheckBox checkBox = new CheckBox();
        checkBox.selectedProperty().setValue(person.isUnemployed());
        checkBox.selectedProperty().addListener((ov, old_val, new_val) -> {
            person.setUnemployed(new_val);
        });
        return new SimpleObjectProperty(checkBox);
    }
}