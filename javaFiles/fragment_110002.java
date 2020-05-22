String member = "Stack";
String book = "overflow";
Data issueDate = date;
....
Object[] row = { member, book, issueDate, returnDate, remarks };
DefaultTableModel model = (DefaultTableModel)table.getModel();
model.addRow(row);