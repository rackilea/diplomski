DefaultTableModel model = new DefaultTableModel(columns, 0)
{
    @Override
    public Class getColumnClass(int column)
    {
        switch (column)
        {
            case 3: return Double.class;
            default: return String.class;
        }
    }
};