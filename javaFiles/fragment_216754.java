Visitor v = new Visitor() {
    List<String> fromTable = new ArrayList<String>();
    List<String> fields = new ArrayList<String>();

    // other Visitor methods go here, not copied for conciseness. 

    @Override
    public Visitable visit(Visitable arg0) throws StandardException {
        // other code from your visit() method goes here
        // 
        if (arg0 instanceof FromBaseTable) {
           FromBaseTable table = (FromBaseTable)arg0;
           fromTable.append(table.getTableName());
        } else if (arg0 instanceof ColumnReference) {
           ColumnReference column = (ColumnReference) arg0;
           fields.append(column.getColumnName())
        }
        // Remove the call to create QueryDescription
    }
    public QueryDescription getQueryDescription() {
        return new QueryDescription(se, fromTable, fields)
    }
}