Vector<Vector> data = new Vector<>();
Vector<String> columnName = new Vector();
...
while ((line = reader.nextLine()) != null) {
    Vector row = new Vector();
    // tokenize and add the `row`
    data.add(row);
}

DefaultTableModel model = new DefaultTableModel(data, columnsNames);
JTable table = new JTable(model);