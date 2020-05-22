DefaultTableModel dTable= new DefaultTableModel(0, 0)
    {
        public Class getColumnClass(int column) 
        {
            return getValueAt(0, column).getClass();
        };
    };