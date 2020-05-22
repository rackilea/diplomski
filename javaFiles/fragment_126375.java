data = get();

//create header for the table
header = new Vector<String>();
header.add("Column1"); 
header.add("Column2");
...
model=new DefaultTableModel(data,header);
table = new JTable(model);