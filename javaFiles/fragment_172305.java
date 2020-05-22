static class CustomRenderer extends DefaultTableCellRenderer {

    @SuppressWarnings("compatibility:-3065188367147843914")
    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component cellComponent
                = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //get the current cell component
        //get the time as String from the current cell at position (row,column)
        //if the string value of time is less than the string representing 5 minutes color it red, else white. 
        //Because of lexicographic alphabet sorting, we can compare the strings correctly like this
        String time = (String) table.getValueAt(row, column);
        if (time!=null && time.compareTo("00:05:00") <= 0) {
            cellComponent.setBackground(Color.RED);
        } else {
            cellComponent.setBackground(Color.WHITE);
        }
        return cellComponent;
    }
}