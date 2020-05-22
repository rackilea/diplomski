table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
table.getSelectionModel().setCellSelectionEnabled(true);

table.addEventFilter(MouseEvent.MOUSE_PRESSED, (event) -> {
    if(event.isShortcutDown() || event.isShiftDown())
        event.consume();
});


table.getFocusModel().focusedCellProperty().addListener((obs, oldVal, newVal) -> {

    if(newVal.getTableColumn() != null){
        table.getSelectionModel().selectRange(0, newVal.getTableColumn(), table.getItems().size(), newVal.getTableColumn());
        System.out.println("Selected TableColumn: "+ newVal.getTableColumn().getText());
        System.out.println("Selected column index: "+ newVal.getColumn());
    }
});

table.addEventFilter(MouseEvent.MOUSE_PRESSED, (event) -> {
    if(event.isShortcutDown() || event.isShiftDown())
        event.consume();
});