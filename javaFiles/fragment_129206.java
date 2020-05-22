class MyClassCellRenderer implements TableCellRenderer {
  MyClassCellComponent panel;

  public MyClassCellRenderer() {
    panel = new MyClassCellComponent();
  }

  public Component getTableCellRendererComponent(JTable table, Object value,        boolean isSelected, boolean hasFocus, int row, int column) {
    MyClass myClass = (MyClass)value;
    panel.updateData(myClass, isSelected, table);
    return panel;
  }
}