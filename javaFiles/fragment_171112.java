class MyDataModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return _Memberships.size();
        }

        @Override
        public int getColumnCount() {
            return _Memberships.size();
        }

        @Override
        public String getColumnName(int column) {
            // Here feel free to return the appropriate column names.
            return super.getColumnName(column);
        }

        @Override
        public Object getValueAt(int row, int column) {
            return NUHPADX(_Memberships.get(row).getId(), _Memberships.get(column).getId());
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            // Here you can do whatever you want to say that is editable or not
            // If it is editable, you need to override setValueAt
            return true;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            // Here you need to implement the update of your model
        }

    }