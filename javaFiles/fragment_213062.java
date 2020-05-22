List<Map> rows = getJdbcTemplate().queryForList(sql);

MyObject obj = null;

for (Map row : rows) {
    // configure the first 3 fields upon object creation.
    if (obj == null) {
        obj = new MyObject(row.get("firstField"), row.get("secondField"), row.get("thirdField"));
    }   

    // basically add each item into the list 
    obj.addToList(row.get("fourthField"));
}