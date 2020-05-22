DefaultTableModel model1 = (DefaultTableModel) cputable.getModel();
Vector data = model1.getDataVector();
Object rowObj = data.get(row);

Vector newData = new Vector(1);
newData.add(rowObj);

DefaultTableModel model2 = (DefaultTableModel) cputablebottom.getModel();
model2.setRowCount(0);
model2.addRow(newData);