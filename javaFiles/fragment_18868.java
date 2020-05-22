public boolean isCellEditable(int row, int column) {

            if (column == 0) return true;

            if (column == 1 || column == 4 || column == 5) return false;

            return (Boolean)getValueAt(row, 0);
        }