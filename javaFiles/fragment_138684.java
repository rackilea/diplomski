DefaultTableModel model = new DefaultTableModel(); 
 JTable table = new JTable(model); 

 // Create a couple of columns 
 model.addColumn("Col1"); 
 model.addColumn("Col2"); 

 // Append a row 
 model.addRow(new Object[]{"v1", "v2"});