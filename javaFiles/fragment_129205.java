class MyClassCellComponent extends JPanel() {
  MyClass myClass;

  public MyClassCellComponent() {
    // initialize components (labels, buttons, etc.)
    // add action listeners
  }

  public void updateData(MyClass myClass, boolean isSelected, JTable table) {
    this.myClass = myClass;
    // update buttons, labels etc. accordingly
  }
}