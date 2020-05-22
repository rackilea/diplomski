public class Test {

    public static class Filter extends RowFilter<TableModel, Integer> {
        private String includePrefix = "Foo";

        @Override
        public boolean include(
                javax.swing.RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
            return entry.getStringValue(0).startsWith( includePrefix );
        }

        // Calling this method changes the filter to allow a different prefix
        public void swapPrefix() {
            this.includePrefix = this.includePrefix.equals("Foo") ? "Bar" : "Foo";
        }
    }

    public static void main(String[] args) {
        //setup
        JFrame frame = new JFrame();
        frame.setLayout( new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        JTable table = new JTable( new Object[][]{ new Object[]{ "Foo 1" },
                                                   new Object[]{ "Bar 1" },
                                                   new Object[]{ "Foo 2" },
                                                   new Object[]{ "Foo 3" },
                                                   new Object[]{ "Bar 2" }},

                                   new Object[] { "Foo"});

        //create and configure sorter
        Filter filter = new Filter();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        sorter.setRowFilter(filter);
        table.setRowSorter(sorter);

        JButton changeFilter = new JButton( "Change filter");
        // pressing the button changes the filter first, then tells the table sorter to update the display
        changeFilter.addActionListener( e -> { filter.swapPrefix(); table.getRowSorter().allRowsChanged(); });

        //display window
        frame.add( table );
        frame.add(changeFilter);
        frame.pack();
        frame.setVisible( true );
    }
}