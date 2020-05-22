final JTable table = new JTable(model)
    {
            @Override
        public Component prepareRenderer(TableCellRenderer renderer,int row,int column)
        {
            Component comp=super.prepareRenderer(renderer,row, column);
           int modelRow=convertRowIndexToModel(row);
           if((Boolean)getValueAt(row,5))
               comp.setBackground(Color.LIGHT_GRAY);
           else
               comp.setBackground(Color.WHITE);
           return comp;
        }
    };