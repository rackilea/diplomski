ShipperAgent sa = new ShipperAgent(...);
DefaultTableModel model1 = new DefaultTableModel(...);
DefaultTableModel model2 = new DefaultTableModel(...);

Coordinator coordinator1 = new Coordinator(sa, model1) {
    @Override
    public void notifyAndAddRow(Object[] rowData) {
        this.shipperAgent.newTruck((String) rowData[0]);
        this.tableModel.addRow(rowData); // do this in the EDT
    }

    @Override
    public void notifyAndDeleteRow(int rowIndex) {
        String truck = (String)this.tableModel.getValueAt(rowIndex, 0);
        this.shipperAgent.removeTruck(truck);
        this.tableModel.removeRow(rowIndex); // do this in the EDT
    }
};

Coordinator coordinator2 = new Coordinator(sa, model2) {
    @Override
    public void notifyAndAddRow(Object[] rowData) {
        this.shipperAgent.activateTruck((String) rowData[0]);
        this.tableModel.addRow(rowData); // do this in the EDT
    }

    @Override
    public void notifyAndDeleteRow(int rowIndex) {
        String truck = (String)this.tableModel.getValueAt(rowIndex, 0);
        this.shipperAgent.removeTruck(truck);
        this.tableModel.removeRow(rowIndex); // do this in the EDT
    }
};