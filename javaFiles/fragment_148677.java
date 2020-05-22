table.setRowFactory(tv -> {
    TableRow<Person> row = new TableRow<>();
    row.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
        if (e.getButton() == MouseButton.SECONDARY) {
            e.consume();
        }
    });
    return row ;
});