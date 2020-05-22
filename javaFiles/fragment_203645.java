this.jTable1.getColumnModel().getColumn(0).setCellEditor(new javax.swing.table.TableCellEditor(){
    @Override
    public java.awt.Component getTableCellEditorComponent(javax.swing.JTable table, java.lang.Object value, boolean isSelected, int row, int column) {
        return new javax.swing.JRadioButton();
    }

    @Override
    public java.lang.Object getCellEditorValue() {
return null;//Here you can return the radio button status
    }

    @Override
    public boolean isCellEditable(java.util.EventObject anEvent) {
        return false; //uneditable cell
    }

    @Override
    public boolean shouldSelectCell(java.util.EventObject anEvent) {
        return false;
    }

    @Override
    public boolean stopCellEditing() {
        return true;
    }

    @Override
    public void cancelCellEditing() {       
    }

    @Override
    public void addCellEditorListener(javax.swing.event.CellEditorListener l) {
    }

    @Override
    public void removeCellEditorListener(javax.swing.event.CellEditorListener l) {
    }

});