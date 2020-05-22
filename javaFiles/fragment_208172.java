import java.util.ArrayList;
import java.util.List;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node ;
import javafx.scene.control.Toggle;

public class ToggleSet<T extends Node & Toggle>  {

    private final ObservableList<T> toggles = FXCollections.observableArrayList(t -> new Observable[] {t.selectedProperty()});
    private final ObservableList<T> selectedToggles = FXCollections.observableArrayList();
    private final IntegerProperty maximumSelectable = new SimpleIntegerProperty(0);

    private final ChangeListener<Boolean> toggleListener = (obs, wasSelected, isNowSelected) -> {
        @SuppressWarnings("unchecked")
        T toggle = (T) ((Property<?>)obs).getBean();
        if (isNowSelected) {
            selectedToggles.add(toggle);
            ensureWithinMax();
        } else {
            selectedToggles.remove(toggle);
        }
    };

    public ToggleSet(int maximumSelectable) {

        this.maximumSelectable.addListener((obs, oldMax, newMax) -> ensureWithinMax());
        setMaximumSelectable(maximumSelectable);
    }

    private void ensureWithinMax() {
        if (this.maximumSelectable.get() < selectedToggles.size()) {
            List<Toggle> togglesToClear = new ArrayList<>(selectedToggles.subList(0, selectedToggles.size() - this.maximumSelectable.get()));
            togglesToClear.forEach(t -> t.setSelected(false));
        }
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
        if (toggle.isSelected()) {
            selectedToggles.add(toggle);
            ensureWithinMax();
        }
        toggle.selectedProperty().addListener(toggleListener);
        toggles.add(toggle);
    }

    public void removeToggle(T toggle) {
        toggle.selectedProperty().removeListener(toggleListener);
        toggles.remove(toggle);
    }

}