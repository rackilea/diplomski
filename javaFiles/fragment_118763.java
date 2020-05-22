public static class EmployeeTableModel extends AbstractTableModel {

    protected static String [] COLUMN_NAMES = {"NAME", "ADDRESS", "CITY", "ZICODE"};

    private List<EmployeeDetails> rows = new ArrayList<>(25);

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EmployeeDetails ed = rows.get(rowIndex);
        switch (columnIndex) {
            case 0: return ed.getName();
            case 1: return ed.getAddress();
            case 2: return ed.getCity();
            case 3: return ed.getZip();
        }
        return null;
    }

    public void add(EmployeeDetails ed) {
        rows.add(ed);
        int row = rows.size() - 1;
        fireTableRowsInserted(row, row);
    }

    public void remove(EmployeeDetails ed) {
        int row = rows.indexOf(ed);
        if (row < 0) {
            return;
        }
    }

    public void remove(int row) {
        if (row < 0 || row > rows.size()) {
            return;
        }
        rows.remove(row);
        fireTableRowsInserted(row, row);
    }
}