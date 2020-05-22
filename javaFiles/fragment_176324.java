tableView.addEventHandler(MouseEvent.MOUSE_CLICKED, evt -> {
    if (evt.getButton() == MouseButton.MIDDLE) {
        TableCell<Person, ?> cell = findCell(evt, tableView);
        if (cell != null && !cell.isEmpty()) {
            System.out.println(cell.getText());
            evt.comsume();
        }
    }
});