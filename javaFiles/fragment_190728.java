import java.util.Objects;
import java.util.function.IntFunction;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventDispatcher;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

public class CustomTableCell<S, T> extends TableCell<S, T> {

    /* 
     * -- CODE OMITTED --
     *
     * The factory methods (forTableColumn) and properties (extractor
     * and converter) have been omitted for brevity. They are defined
     * and used exactly the same way as in the previous example.
     */

    private Property<T> property;
    private TextField textField;

    public CustomTableCell(IntFunction<Property<T>> extractor, StringConverter<T> converter) {
        setExtractor(extractor);
        setConverter(converter);
    }

    @Override
    public void updateSelected(boolean selected) {
        super.updateSelected(selected);
        if (selected && !isEmpty()) {
            textField.requestFocus();
        }
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
            clearProperty();
        } else {
            initializeTextField();
            clearProperty();

            property = getExtractor().apply(getIndex());
            Bindings.bindBidirectional(textField.textProperty(), property, getConverter());

            setGraphic(textField);
            if (isSelected()) {
                textField.requestFocus();
            }
        }
    }

    private void clearProperty() {
        if (property != null) {
            Bindings.unbindBidirectional(textField.textProperty(), property);
            textField.setText(null);
            property = null;
        }
    }

    private void initializeTextField() {
        if (textField == null) {
            textField = new TextField();
            textField.focusedProperty().addListener((observable, wasFocused, isFocused) -> {
                if (isFocused && !isSelected()) {
                    getTableView().getSelectionModel().clearAndSelect(getIndex(), getTableColumn());
                }
            });

            /*
             * TableView has key handlers that will select cells based on arrow keys being
             * pressed, scrolling to them if necessary. I find this mechanism looks cleaner
             * because, unlike TableView#scrollTo, it doesn't cause the cell to jump to the
             * top of the TableView.
             *
             * The way this works is by bypassing the TextField if, and only if, the event
             * is a KEY_PRESSED event and the pressed key is an arrow key. This lets the
             * event bubble up back to the TableView and let it do what it needs to. All
             * other key events are given to the TextField for normal processing.
             *
             * NOTE: The behavior being relied upon here is added by the default TableViewSkin
             *       and its corresponding TableViewBehavior. This may not work if a custom
             *       TableViewSkin skin is used.
             */
            EventDispatcher oldDispatcher = textField.getEventDispatcher();
            textField.setEventDispatcher((event, tail) -> {
                if (event.getEventType() == KeyEvent.KEY_PRESSED
                        && ((KeyEvent) event).getCode().isArrowKey()) {
                    return event;
                } else {
                    return oldDispatcher.dispatchEvent(event, tail);
                }
            });
        }
    }

}