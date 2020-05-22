class MyClassTableModel extends DefaultTableModel {
  List<MyClass> data;

  public MyClassTableModel(List<MyClass> data) {
    this.data = data;
  }

  public Class<?> getColumnClass(int columnIndex) { return MyClass.class; }
  public int getColumnCount() { return 1; }
  public String getColumnName(int columnIndex) { return "MyClass"; }
  public int getRowCount() { return (data == null) ? 0 : data.size(); }
  public Object getValueAt(int rowIndex, int columnIndex) { return data.get(rowIndex); }
  public boolean isCellEditable(int rowIndex, int columnIndex) { return true; }
}