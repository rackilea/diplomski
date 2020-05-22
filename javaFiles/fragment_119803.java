package application;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;

public class LabeledComboBoxController<T> {
    @FXML
    private Label label ;
    @FXML
    private ComboBox<T> comboBox ;

    public void setText(String text) {
        label.setText(text);
    }
    public String getText() {
        return label.getText();
    }
    public StringProperty textProperty() {
        return label.textProperty();
    }

    public ObservableList<T> getItems() {
        return comboBox.getItems();
    }
    public void setItems(ObservableList<T> items) {
        comboBox.setItems(items);
    }

    public boolean isWrapText() {
        return label.isWrapText();
    }

    public void setWrapText(boolean wrapText) {
        label.setWrapText(wrapText);
    }

    public BooleanProperty wrapTextProperty() {
        return label.wrapTextProperty();
    }

    public SingleSelectionModel<T> getSelectionModel() {
        return comboBox.getSelectionModel();
    }
}