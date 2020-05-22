String[] columnNames = new String[]{"dataHeader1", "dataHeader2"};
DefaultTableModel tableModel = new DefaultTableModel();


//you can do a for loop here...
Object[][] data= new Object[5][columnNames.length];
data[0][0] = "";
data[0][1] = "";

data[1][0] = "";
data[1][1] = "";
...

tableModel.setDataVector(data, columnNames);