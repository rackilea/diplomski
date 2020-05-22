import java.util.Objects;
import java.util.function.IntFunction;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView.TableViewFocusModel;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

public class CustomTableCell<S, T> extends TableCell<S, T> {

    public static <S> Callback<TableColumn<S, String>, TableCell<S, String>> forTableColumn(
            IntFunction<Property<String>> extractor) {
        return forTableColumn(extractor, new DefaultStringConverter());
    }

    public static <S, T> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumn(
            IntFunction<Property<T>> extractor, StringConverter<T> converter) {
        Objects.requireNonNull(extractor);
        Objects.requireNonNull(converter);
        return column -> new CustomTableCell<>(extractor, converter);
    }

    private final ObjectProperty<IntFunction<Property<T>>> extractor = new SimpleObjectProperty<>(this, "extractor");
    public final void setExtractor(IntFunction<Property<T>> callback) { extractor.set(callback); }
    public final IntFunction<Property<T>> getExtractor() { return extractor.get(); }
    public final ObjectProperty<IntFunction<Property<T>>> extractorProperty() { return extractor; }

    private final ObjectProperty<StringConverter<T>> converter = new SimpleObjectProperty<>(this, "converter");
    public final void setConverter(StringConverter<T> converter) { this.converter.set(converter); }
    public final StringConverter<T> getConverter() { return converter.get(); }
    public final ObjectProperty<StringConverter<T>> converterProperty() { return converter; }

    private Property<T> property;
    private TextField textField;

    public CustomTableCell(IntFunction<Property<T>> extractor, StringConverter<T> converter) {
        setExtractor(extractor);
        setConverter(converter);

        // Assumes this TableCell will never become part of a different TableView
        // after the first one. Also assumes the focus model of the TableView will
        // never change. These are not great assumptions (especially the latter),
        // but this is only an example.
        tableViewProperty().addListener((obs, oldTable, newTable) ->
                newTable.getFocusModel().focusedCellProperty().addListener((obs2, oldPos, newPos) -> {
                    if (getIndex() == newPos.getRow() && getTableColumn() == newPos.getTableColumn()) {
                        textField.requestFocus();
                    }
                })
        );
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
            cleanUpProperty();
        } else {
            initializeTextField();
            cleanUpProperty();

            property = getExtractor().apply(getIndex());
            Bindings.bindBidirectional(textField.textProperty(), property, getConverter());

            setGraphic(textField);
            if (getTableView().getFocusModel().isFocused(getIndex(), getTableColumn())) {
                textField.requestFocus();
            }
        }
    }

    private void cleanUpProperty() {
        if (property != null) {
            Bindings.unbindBidirectional(textField.textProperty(), property);
            property = null;
        }
    }

    private void initializeTextField() {
        if (textField == null) {
            textField = new TextField();
            textField.addEventFilter(KeyEvent.KEY_PRESSED, this::processArrowKeys);
            textField.focusedProperty().addListener((observable, wasFocused, isFocused) -> {
                if (isFocused) {
                    getTableView().getFocusModel().focus(getIndex(), getTableColumn());
                }
            });
        }
    }

    private void processArrowKeys(KeyEvent event) {
        if (event.getCode().isArrowKey()) {
            event.consume();

            TableViewFocusModel<S> model = getTableView().getFocusModel();
            switch (event.getCode()) {
                case UP:
                    model.focusAboveCell();
                    break;
                case RIGHT:
                    model.focusRightCell();
                    break;
                case DOWN:
                    model.focusBelowCell();
                    break;
                case LEFT:
                    model.focusLeftCell();
                    break;
                default:
                    throw new AssertionError(event.getCode().name());
            }
            getTableView().scrollTo(model.getFocusedCell().getRow());
            getTableView().scrollToColumnIndex(model.getFocusedCell().getColumn());
        }
    }

}