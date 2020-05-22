public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {
        // Is the table in edit mode?
        if (table.isEditing()) {
            // Get the current editor
            TableCellEditor editor = table.getCellEditor();
            if (editor != null) {
                // Try and stop the cell editing process
                if (!editor.stopCellEditing()) {
                    // Cancel the editing if can't be stopped...
                    // You could handle an error state here instead...
                    editor.cancelCellEditing();
                }
            }
        }
        System.out.println(table.getValueAt(0, 0));
        System.out.println(table.getValueAt(0, 1));
    }
}