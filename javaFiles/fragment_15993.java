//Names of the columns
String columns[] = {"Line no","Program statement","Complexity count"};

//Table model, initiate with 0 columns
DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

JTable table = new JTable(tableModel);