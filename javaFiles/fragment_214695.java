//initializes the table
 JTable table=new JTable(rowData, columnNames);
//add table header to any component(panel)
component.add(table.getTableHeader());
//add table to any component(panel)
component.add(tableRelatedProducts);