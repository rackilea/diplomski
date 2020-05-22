int rowModelId = convertRowIndexToModel( row );
if (!isRowSelected(row)) {
    if (tableR.getColumnCount() >= 0) {
        String type = (String) getModel().getValueAt(rowModelId , 11);
        c.setBackground("0.0".equals(type) ? Color.RED : Color.WHITE);
        c.setForeground("0.0".equals(type) ? Color.WHITE : Color.BLACK);
        c.setFont("0.0".equals(type) ? myFont1: myFont);
     }
}