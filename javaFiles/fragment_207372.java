String[] columnNames = {"#", "Number"};
DefaultTableModel model = new DefaultTableModel(columnNames, 0)
{
    //  Returning the Class of each column will allow different
    //  renderers and editors to be used based on Class

    public Class getColumnClass(int column)
    {
        return column == 0 ? Boolean.class : Integer.class;
    }
};

JTable table = new JTable(model);