DefaultTableModel model = new DefaultTableModel(COL_NAMES, 0) {
     @Override
     public Class<?> getColumnClass(int column) {
        if (getRowCount() > 0) {
           Object value = getValueAt(0, column);
           if (value != null) {
              return getValueAt(0, column).getClass(); 
           }
        }

        return super.getColumnClass(column);
     }
  };