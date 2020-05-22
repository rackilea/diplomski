protected int update(String query, Object[] values) {
    //...
    stmt = con.prepareStatement(query);
    for (int index = 0; index < values.length; index++) {
         Object value = values[index];
         stmt.bindObject((index + 1), value);
    }
    //...
}