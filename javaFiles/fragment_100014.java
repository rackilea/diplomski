Vector<String> columnNames = new Vector<String>();
columnNames.add("ID");
columnNames.add("RSSI");

Vector<Vector<String>> rowData = new Vector<Vector<String>>();

for(int i=0; i<20; i++) {
    Vector<String> row = new Vector<String>();
    row.add("ID_" + i);
    row.add("RSSI_" + i);
    rowData.add(row);
}

JTable table = new JTable(rowData, columnNames);