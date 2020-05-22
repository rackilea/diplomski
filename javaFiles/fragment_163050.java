class MyDefaultCellEditor extends DefaultCellEditor {

public MyDefaultCellEditor(JComboBox comboBox) {
    super(comboBox);
}

@Override
public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
   //return custom coponent
    return super.getTableCellEditorComponent(table, value, isSelected, row, column);
}
}