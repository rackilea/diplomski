import java.util.ArrayList;
import java.util.List;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Node ;
import javafx.scene.control.Toggle;

public class ToggleSet<T extends Node & Toggle>  {

    private final ObservableList<T> toggles = FXCollections.observableArrayList(t -> new Observable[] {t.selectedProperty()});
    private final FilteredList<T> selectedToggles = toggles.filtered(t -> ((Toggle)t).isSelected());
    private final IntegerProperty maximumSelectable = new SimpleIntegerProperty(0);

    private final IntegerBinding numSelected = Bindings.size(selectedToggles);

    public ToggleSet(int maximumSelectable) {

        this.maximumSelectable.addListener((obs, oldMax, newMax) -> {
            if (newMax.intValue() < numSelected.get()) {
                List<Toggle> togglesToClear = new ArrayList<>(selectedToggles.subList(0, numSelected.get() - newMax.intValue()));
                togglesToClear.forEach(t -> t.setSelected(false));
            }
        });

        setMaximumSelectable(maximumSelectable);
    }

    public ToggleSet() {
        this(0);
    }

    public ObservableList<T> getSelectedToggles() {
        return FXCollections.unmodifiableObservableList(selectedToggles) ;
    }

    public IntegerProperty maximumSelectableProperty() {
        return maximumSelectable ;
    }

    public final int getMaximumSelectable() {
        return maximumSelectableProperty().get();
    }

    public final void setMaximumSelectable(int maximumSelectable) {
        maximumSelectableProperty().set(maximumSelectable);
    }

    public void addToggle(T toggle) {
        if (numSelected.get() >= getMaximumSelectable()) {
            toggle.setSelected(false);
        }
        toggles.add(toggle);
        toggle.disableProperty().bind(toggle.selectedProperty().not().and(numSelected.greaterThanOrEqualTo(maximumSelectable)));
    }

    public void removeToggle(T toggle) {
        toggles.remove(toggle);
        toggle.disableProperty().unbind();
    }

}