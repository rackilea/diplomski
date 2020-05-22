private void toggleRow(TableRow tableRow) {
    if (this.disabledRows.contains(tableRow)) {
        this.disabledRows.remove(tableRow);
        tableRow.getStyleClass().remove("cell-disabled");
    } else {
        this.disabledRows.add(tableRow);
        tableRow.getStyleClass().add("cell-disabled");
    }
}

private void toggleColumn(TableColumn tableColumn) {
    System.out.println(tableColumn);
    if (this.disabledColumns.contains(tableColumn)) {
        this.disabledColumns.remove(tableColumn);
        tableColumn.getStyleClass().remove("cell-disabled");
    } else {
        this.disabledColumns.add(tableColumn);
        tableColumn.getStyleClass().add("cell-disabled");
    }
}