/* move this to the model */
private void fillTable()
{
    tableModel.players.add(new Player("John Doe", 75.50f));
    int row = tableModel.players.size() - 1;
    tableModel.fireTableRowsInserted(n, n);
}