List<Integer> selectedRows = new ArrayList<>(25);
for (int row = 0; row < table.getRowCount(); row++) {
    if (table.getValueAt(row, 4) == Boolean.TRUE) {
        selectedRows.add(row);
    }
}