class MyTableModel extends AbstractTableModel {
    private final List<String> columnNames;
    private List<RowData>      rows;

    MyTableModel() {
        columnNames = new ArrayList<String>();
        columnNames.add("Name");
        //...
        rows = new ArrayList<RowData>();
    }

    // populate the table data model with a List
    // that contains parsed data, each list element 
    // could correspond to a record or line (say)
    void setCoreData(final List<RowData> data) {
        this.rows = data;
    }

    public Object getValueAt(final int pRow, final int pCol) {
        if (getColumnName(pCol).equals("Name")) {
            return rows.get(pRow).getName();
        }
        //... .

    }

// corresponds to the rows of table instances of which 
// are created by output of parsing
private class RowData {
    private String name;

    public Object getName() {
        return name;
    }
}

// table instantitaion can be as below (say)
JTable myTable = new JTable(new MyTableModel());