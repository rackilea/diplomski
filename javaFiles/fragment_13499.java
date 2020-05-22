public class SpreadsheetImportTemplate {

    private Integer id;
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    private Collection<SpreadsheetImportTemplateColumn> columns = new ArrayList<SpreadsheetImportTemplateColumn>();
    public Collection<SpreadsheetImportTemplateColumn> getColumns() { return columns; }
    public void setColumns(Collection<SpreadsheetImportTemplateColumn> columns) { this.columns = columns; }

    /**
     * set up both sides
     */
    public void addColumn(SpreadsheetImportTemplateColumn column) {
        getColumns().add(column);

        column.setTemplate(this);
    }

}