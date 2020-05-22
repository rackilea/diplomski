private String[] columnNames = { "FERT","CLIENTE ","PEP" };
private ArrayList<TheObject> data;

public Object getValueAt(int row, int col) {
    Object value = null;
    TheObject obj = data.get(row);
    switch(col) {
        case 0: value = obj.getFert(); break;
        case 1: value = obj.getCliente(); break;
        case 2: value = obj.getPep(); break;
        default: break;
    }
    return value;
}