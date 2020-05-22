JTable table = new JTable(new DefaultTableModel(objectMatrix, hdrsObjects)) {
  @Override public void updateUI() {
    super.updateUI();
    setRowHeight(30);
    TableColumn tc = getColumn("PanelSpinnerRadioButton Class Column");
    tc.setCellRenderer(new PSRBTableCellRenderer());
    tc.setCellEditor(new PSRBTableCellEditor());
  }
};