@Override
public void propertyChange(PropertyChangeEvent evt) {
    if (evt.getPropertyName().equals(ListModel.CHANGED)) {
        ListModel model = (ListModel) evt.getSource();
        DefaultTableModel tm = (DefaultTableModel) listTable.getModel();
        tm.setRowCount(0);
        for (String s : model.getList()) {
            tm.addRow(new Object[]{s});
        }
    }
}