tableModel = new DefaultTableModel(data,header)
{
    @Override
    public Class getColumnClass(int column)
    {
        switch (column)
        {
            case 2: return Integer.class;
            case 6: return Boolean.class;
            default: return Object.class;
        }
    }
};