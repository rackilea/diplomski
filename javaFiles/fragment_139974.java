JTable table = new JTable(model) {
        @Override
        public TableCellRenderer getCellRenderer(int row, int column) {
            if(getValueAt(row, column) instanceof Boolean) {
                return super.getDefaultRenderer(Boolean.class);
            } else {
                return super.getCellRenderer(row, column);
            }
        }

        @Override
        public TableCellEditor getCellEditor(int row, int column) {
            if(getValueAt(row, column) instanceof Boolean) {
                return super.getDefaultEditor(Boolean.class);
            } else {
                return super.getCellEditor(row, column);
            }
        }
    };