private void buildOutputPanel() {
    outputPanel = new JPanel(new BorderLayout());
    resultTable = new JTable();
    outputPanel.add(new JScrollPane(resultTable));
}

/*Copy ArrayList into 2D array to display in JTable format*/
private void printData() {
    for (int i = 0; i < name.size(); i++) {
        data[i][0] = name.get(i);
        data[i][2] = department.get(i);
        data[i][2] = salary.get(i);
    }
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    resultTable.setModel(model);
}