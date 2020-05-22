public class TableExample extends JFrame{
    public TableExample()
    {
        //headers for the table
        String[] columns = new String[] {
            "Field", "Boolean Value1", "Boolean Value2"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {"Check YX", false, false },
            {"Check XZ", true, true },
        };

        //create table with data
        JTable table = new JTable(data, columns);

        //add the table to the frame
        this.add(new JScrollPane(table));

        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableExample();
            }
        });
    }   
}