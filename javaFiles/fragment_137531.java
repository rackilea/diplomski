model = new DefaultTableModel() {

    private static final long serialVersionUID = 1L;
    String[] employee = {"Employee 1", "Employee 2"};

    @Override
    public int getColumnCount() {
         return employee.length;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
         return false;
    }

    @Override
    public int getRowCount() {
         return Inform.getRowCount();
    }

    @Override
    public String getColumnName(int index) {
        return employee[index];
    }
};