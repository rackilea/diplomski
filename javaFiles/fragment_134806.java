public class BulkEditAction extends AbstractAction {
    JTable table;
    List selectedCells;

    public BulkEditAction(JTable table) {
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        // store, here rows only, refine for cell selection
        selectedCells = Arrays.asList(table.getSelectedRows());
        final int rowToEdit =  // ...
        final int columnToEdit = // ...
        table.editCellAt(rowToEdit, columnToEdit);
        CellEditorListener l = new CellEditorListener() {

            @Override
            public void editingStopped(ChangeEvent e) {
                ((AbstractCellEditor) e.getSource()).removeCellEditorListener(this);
                propagateEditedValue(rowToEdit, columnToEdit);

            }

            @Override
            public void editingCanceled(ChangeEvent e) {
                ((AbstractCellEditor) e.getSource()).removeCellEditorListener(this);
            }
        };
        table.getCellEditor().addCellEditorListener(l);
    }

    private void propagateEditedValue(final int row, final int column) {
        // need to invoke to be sure that the table has updated itself after
        // editingStopped
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // foreach selectedCell (with coordinates selectedRow/-column
                table.setValueAt(table.getValueAt(row, column), selectedRow, selectedColumn);
            }
        });
    }
}