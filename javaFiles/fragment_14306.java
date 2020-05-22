public void removeVehicle(final DefaultTableModel model, final int index) {
    String value = (String)model.getValueAt(index, 0);
    shipperAgent.deactivateTruck(value);
    // If everything went ok, then remove the row from the table model.
    // Of course, do it in the Event Dispatch Thread.
    model.removeRow(index);
}