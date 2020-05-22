String[] header = new String[] { "qty", "price", "amt" };
DefaultTableModel model = new DefaultTableModel(header, 1) {

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Integer.class;
            case 1: 
            case 2: return Double.class;
        }
        throw new ArrayIndexOutOfBoundsException(columnIndex);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column < 2;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        super.setValueAt(aValue, row, column);
        if (column < 2) {
            Integer qty = (Integer)getValueAt(row, 0);
            Double price = (Double)getValueAt(row, 1);
            Double amt = (qty != null && price != null) 
                       ? (Double)(qty * price)
                       : null;
            super.setValueAt(amt, row, 2);
        }
    }
};