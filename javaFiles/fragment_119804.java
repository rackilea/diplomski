package application;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.VBox;

public class LabeledComboBox<T> extends VBox {

    private final LabeledComboBoxController<T> controller ;

    public LabeledComboBox(ObservableList<T> items, String text) {
        controller = load();
        if (controller != null) {
            setText(text);
            setItems(items);
        }
    }

    public LabeledComboBox(ObservableList<T> items) {
        this(items, "");
    }

    public LabeledComboBox(String text) {
        this(FXCollections.observableArrayList(), text);
    }

    public LabeledComboBox() {
        this("");
    }

    private LabeledComboBoxController<T> load() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "LabeledComboBox.fxml"));
            loader.setRoot(this);
            loader.load();
            return loader.getController() ;
        } catch (Exception exc) {
            Logger.getLogger("LabeledComboBox").log(Level.SEVERE,
                    "Exception occurred instantiating LabeledComboBox", exc);
            return null ;
        }
    }

    // Expose properties, but just delegate to controller to manage them 
    // (by delegating in turn to the underlying controls):

    public void setText(String text) {
        controller.setText(text);
    }
    public String getText() {
        return controller.getText();
    }
    public StringProperty textProperty() {
        return controller.textProperty();
    }

    public boolean isWrapText() {
        return controller.isWrapText();
    }

    public void setWrapText(boolean wrapText) {
        controller.setWrapText(wrapText);
    }

    public BooleanProperty wrapTextProperty() {
        return controller.wrapTextProperty();
    }

    public ObservableList<T> getItems() {
        return controller.getItems();
    }
    public void setItems(ObservableList<T> items) {
        controller.setItems(items);
    }
    public SingleSelectionModel<T> getSelectionModel() {
        return controller.getSelectionModel();
    }
}