if (textField1.getValue().trim().length > 0) {
  query += " and COLUMN1 = " + textField1.getValue().trim() + " ";
}
if (textField2.getValue().trim().length > 0) {
  query += " and COLUMN2 = " + textField2.getValue().trim() + " ";
}