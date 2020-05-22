DefaultTableModel suppliersModel = (DefaultTableModel) jSuppliersTable.getModel();
for(Suppliers suppliers : manager.allSuppliers()) {
    suppliersModel.addRow(new Object[]{suppliers.getId()});

    int id = (Integer) suppliersModel.getValueAt(0, 0);
    if(id == -1) {
        suppliersModel.removeRow(0);
    }