public void loadAllItems() {
    String sql = buildSQL();
    List<Map<String, Object>> query = DB.rows(sql, new RowBounds(0, maxRows+1));        
    this.rows = new ArrayList<Item>();
    for (Map<String,Object> row : query) {
        Item item = new PropertysetItem();
        for (Object colName : this.colNames) {
            Object value = row.get(colName);
            if (value!=null) {
                item.addItemProperty(colName, new ObjectProperty(value));
            }
        }

        this.rows.add(item);
    }       
}