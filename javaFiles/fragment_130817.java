JTable table = new JTable(new AbstractTableModel() {
            public String getColumnName(int column) { return columnNames[column].toString(); }
            public int getRowCount() { return dataValues.length; }
            public int getColumnCount() { return columnNames.length; }
            public Object getValueAt(int row, int col) { return dataValues[row][col]; }
            public boolean isCellEditable(int row, int column) { return false; }
        });