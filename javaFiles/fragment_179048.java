tablecolumn.getCellEditor()
           .addCellEditorListener(new CellChangeListener());


private class CellChangeListener implements CellEditorListener {

    @Override
    public void editingStopped(ChangeEvent e) {
        DefaultCellEditor editor;
        Object newValue;
        if (e.getSource() instanceof DefaultCellEditor) {
            editor = (DefaultCellEditor) e.getSource();

            newValue = editor.getCellEditorValue();

            if (newValue != null) {
                //set the newValue for the combobox selection manager
            }
        }
    }

    @Override
    public void editingCanceled(ChangeEvent e) {
    }
}