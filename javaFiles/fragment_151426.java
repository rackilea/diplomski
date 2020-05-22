public Component getTableCellEditorComponent(JTable table, Object value, 
                             boolean isSelected, int row, int column ) {
    textField.setText(value.toString());
    textField.selectAll();
    return textField;
}