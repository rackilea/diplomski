private class AddBotCell extends TableCell<Bot, Boolean> {
    // a button for adding a new person.
    final CheckBox checkbox = new CheckBox();
    // pads and centers the add button in the cell.
    final StackPane paddedCheckBox = new StackPane();
    // records the y pos of the last button press so that the add person dialog can be shown next to the cell.
    final DoubleProperty buttonY = new SimpleDoubleProperty();
    private boolean updating = false;

    AddBotCell(/*final Stage stage, final TableView table*/) {
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        paddedCheckBox.setPadding(new Insets(3));
        paddedCheckBox.getChildren().add(checkbox);
        checkbox.selectedProperty().addListener((o, oldValue, newValue) -> {
            if (!updating) {
                updating = true;
                ((Bot)getTableRow().getItem()).setIsOn(newValue);
                updating = false;
            }
        });
    }

    /** places an add button in the row only if the row is not empty. */
    @Override protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            setGraphic(paddedCheckBox);
            updating = true;
            checkbox.setSelected(item);
            updating = false;
        }
    }
}