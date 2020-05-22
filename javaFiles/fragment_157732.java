public class Grid {
    private Row headerColumns;
    private List<Row> dataRows;

    public Grid() {
        dataRows = new LinkedList<Row>();
    }

    public Grid(int rowCount) {
        dataRows = new ArrayList<Row>(rowCount);
    }

    public void addHeaderRow(List<String> headers) {
        this.headerColumns = new Row(headers);
    }

    public void addDataRow(List<String> data) {
        this.dataRows.add( new Row(data) );
    }

    public List<Row> getAllData() {
        List<Row> data = new ArrayList<Row>(1+dataRows.size());
        data.add(this.headerColumns);
        data.addAll(dataRows);
        return data;
    }

    public Row getHeaderColumns() {
        return headerColumns;
    }

    public List<Row> getDataRows() {
        return dataRows;
    }
}

class Row {
    private List<String> data;

    public Row(List<String> data) {
        this.data = data;
    }

    public void addColumn(String columnData) {
        data.add(columnData);
    }

    public List<String> getData() {
        return data;
    }
}