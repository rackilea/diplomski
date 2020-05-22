public class EditableBigDecimalTableCell<T> extends TableCell<T, BigDecimal> {
private TextField textField;
private int minDecimals, maxDecimals;
/**
 * This is the default - we will use this as 2 decimal places
 */
public EditableBigDecimalTableCell () {
    minDecimals = 2;
    maxDecimals = 2;
}

/**
 * Used when the cell needs to have a different behavior than 2 decimals
 */
public EditableBigDecimalTableCell (int min, int max) {
    minDecimals = min;
    maxDecimals = max;
}

@Override
public void startEdit() {
    if(editableProperty().get()){
        if (!isEmpty()) {
            super.startEdit();
            createTextField();
            setText(null);
            setGraphic(textField);
            textField.requestFocus();
        }
    }
}

@Override
public void cancelEdit() {
    super.cancelEdit();
    setText(getItem() != null ? getItem().toPlainString() : null);
    setGraphic(null);
}

@Override
public void updateItem(BigDecimal item, boolean empty) {
    super.updateItem(item, empty);
    if (empty) {
        setText(null);
        setGraphic(null);
    } else {
        if (isEditing()) {
            if (textField != null) {
                textField.setText(getString());
                textField.selectAll();
            }
            setText(null);
            setGraphic(textField);
        } else {
            setText(getString());
            setGraphic(null);
        }
    }
}

private void createTextField() {
    textField = new TextField();
    textField.setTextFormatter(new DecimalTextFormatter(minDecimals, maxDecimals));
    textField.setText(getString());

    textField.setOnAction(evt -> {
        if(textField.getText() != null && !textField.getText().isEmpty()){
            NumberStringConverter nsc = new NumberStringConverter();
            Number n = nsc.fromString(textField.getText());
            commitEdit(BigDecimal.valueOf(n.doubleValue()));
        }
    });
    textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);

    textField.setOnKeyPressed((ke) -> {
        if (ke.getCode().equals(KeyCode.ESCAPE)) {
            cancelEdit();
        }
    });

    textField.setAlignment(Pos.CENTER_RIGHT);
    this.setAlignment(Pos.CENTER_RIGHT);
}

private String getString() {
    NumberFormat nf = NumberFormat.getNumberInstance();
    nf.setMinimumFractionDigits(minDecimals);
    nf.setMaximumFractionDigits(maxDecimals);
    return getItem() == null ? "" : nf.format(getItem());
}

@Override
public void commitEdit(BigDecimal item) {
    if (isEditing()) {
        super.commitEdit(item);
    } else {
        final TableView<T> table = getTableView();
        if (table != null) {
            TablePosition<T, BigDecimal> position = new TablePosition<T, BigDecimal>(getTableView(),
                    getTableRow().getIndex(), getTableColumn());
            CellEditEvent<T, BigDecimal> editEvent = new CellEditEvent<T, BigDecimal>(table, position,
                    TableColumn.editCommitEvent(), item);
            Event.fireEvent(getTableColumn(), editEvent);
        }
        updateItem(item, false);
        if (table != null) {
            table.edit(-1, null);
        }

    }
}

}