ChangeListener changeListener = new ChangeListener() {
    int previousIndex = 0;

    public void stateChanged(ChangeEvent changeEvent) {
      JTabbedPane tbPane = (JTabbedPane) changeEvent.getSource();
      stopTableEditor(tbPane.getComponentAt(previousIndex));
      previousIndex = tbPane.getSelectedIndex();
    }

    private void stopTableEditor(Component component) {
        JTable table = ... // retrieve table instance from component
        if(table.isEditing())
           table.getCellEditor().stopCellEditing();
    }
};