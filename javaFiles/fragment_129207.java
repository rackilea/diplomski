class MyClassCellEditor extends AbstractCellEditor {
  MyClassCellComponent panel;
  public MyClassCellEditor() {
    panel = new MyClassCellComponent();
  }
  public Component getTableCellEditorComponent(JTable table, Object value,      boolean isSelected, int row, int column) {
    MyClass myClass = (MyClass)value;
    panel.updateData(myClass, true, table);
    return panel;
  }
  public Object getCellEditorValue() {
    return null;
  }
}