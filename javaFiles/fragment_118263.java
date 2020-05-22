// create your JTable model here:
DefaultTableModel model = ......

JTable tablePatientDt = new JTable(model){
@Override
public boolean isCellEditable(int row, int column) {
    return false;
}