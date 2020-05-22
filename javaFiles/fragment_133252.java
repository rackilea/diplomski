ArrayList arrayList = new ArrayList();

  String[] columns = {"Field String","Field Double"," Field Double"};
  DefaultTableModel model = new DefaultTableModel(columns, 0);

  for (Object item : arrayList) {
     Object[] row = new Object[3];
     //... fill in row with info from item

     model.addRow(row);
  }

  JTable table = new JTable(model);