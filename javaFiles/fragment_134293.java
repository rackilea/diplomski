// Apply filter...
int col = ...; // Column you're interested in
List values = new ArrayList(table.getRowCount());
for (int row = 0; row < table.getRowCount(); row++) {
    values.add(table.getValueAt(row, col));
}