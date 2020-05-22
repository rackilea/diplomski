private class MyTableCell extends TableCell<MyRow, String> {

    Boolean hasEventHandler = FALSE;

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty && getTableRow() != null && getTableRow().getItem() != null) {
            MyRow er = (MyRow) getTableRow().getItem();
            TableCell cell = er.get(getTableView().getColumns().indexOf(getTableColumn()));
            this.setText(cell.getText());
            if (cell.getUserData() instanceof MyTableCellEnum) {
                MyTableCellEnumcellType = (MyTableCellEnum) cell.getUserData();
                if (null != cellType && !hasEventHandler) {
                    switch (cellType) {
                        case COLUMN_HEADER:
                            addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    toggleColumn(getTableColumn());
                                }
                            });
                            hasEventHandler = TRUE;
                            break;
                        case ROW_HEADER:
                            addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    toggleRow(getTableRow());
                                }
                            });
                            hasEventHandler = TRUE;
                            break;
                        case DATA:
                            addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    // Do other action on selection
                                }
                            });
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
}