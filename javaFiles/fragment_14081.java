DataTable table = new DataTable(1,4,100,30); //creates table with 1 row (30px tall) and 4 columns (100px wide each)
//table extends java.awt.Panel and it consists a 2D array of Labels which contain text
//class has methods for adding rows and cols, and methods for setting values etc.
table.setLocation(0, 0);
ScrollPane scroll = new ScrollPane();//scroll pane
scroll.setBounds(10, 50, 500, 100);
scroll.add(table);
Frame frame = new Frame();
frame.add(scroll);
frame.setLayout(null);
frame.setSize(600, 500);
frame.setVisible(true);
for ( int i=0 ; i<20 ; i++ ) {
    table.addRow();//add twenty rows to table
}