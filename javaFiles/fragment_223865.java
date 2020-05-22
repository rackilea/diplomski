@SuppressWarnings("serial")
class MyTableModel extends DefaultTableModel {
    private static final String[] COLUMN_NAMES = { "Name", "ID" };

    public MyTableModel() {
        super(COLUMN_NAMES, 0);
    }

    public void addEmployee(RestaurantEmployee employee) {
        addRow(new RestaurantEmployee[] { employee });
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (getRowCount() > 0) {
            return getValueAt(0, columnIndex).getClass();
        } else {
            return super.getColumnClass(columnIndex);
        }
    }

    public RestaurantEmployee getEmployee(int row) {
        return (RestaurantEmployee) super.getValueAt(row, 0);
    }

    @Override
    public Object getValueAt(int row, int column) {
        RestaurantEmployee employee = (RestaurantEmployee) super.getValueAt(row, 0);
        switch (column) {
        case 0:
            return employee.getName();
        case 1:
            return employee.getId();        
        default:
            return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}