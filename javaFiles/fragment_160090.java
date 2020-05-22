JTable table = new JTable();
fillTable(table, biens);
// I put the table in a scroll pane and had to make it bigger...
final JScrollPane tableScrollPane = new JScrollPane(table);
tableScrollPane.setBounds(224, 90, 400, 500);
contentPane.add(tableScrollPane);