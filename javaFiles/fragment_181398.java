public class DefaultWorkSheetTableModel extends AbstractTableModel {

    private List<Employee> items;

    public DefaultWorkSheetTableModel() {
        items = new ArrayList<>(25);
    }

    public DefaultWorkSheetTableModel(List<Employee> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Integer.class;
            case 1: 
            case 2: 
            case 3: return Double.class;
        }
        return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Emp Num";
            case 1: return "Base Pay";
            case 2: return "Hours Worked";
            case 3: return "Pay Amount";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee item = items.get(rowIndex);
        switch (columnIndex) {
            case 0: return item.getNumber();
            case 1: return item.getHourlyRate();
            case 2: return item.getHoursWorked();
            case 3: return item.getPay();
        }
        return null;
    }

    public void add(Employee item) {
        items.add(item);
        int row = items.indexOf(item);
        fireTableRowsInserted(row, row);
    }

    public void remove(Employee item) {
        if (items.contains(item)) {
            int row = items.indexOf(item);
            items.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }

}