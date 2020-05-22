public class Data{

    private List<Row> rows;

    public List<Row> getRows() {
        return rows;
    }

    @XmlAnyElement
    @XmlJavaTypeAdapter(MyRowsAdapter.class)
    public void setRows(List<Row> result) {
        this.rows = rows;
    }

}