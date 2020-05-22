{
...
    StringBuilder sb = new StringBuilder("insert into mytable (");
    List<Object> params = new ArrayList<Object>();

    addColumnAndValue(sb, "DocumentID", docIdYouHaveSomewhere, params);
    int i = 0;
    for (String name: names)
       addColumnAndValue(sb, ",name" + i, name, params);
    i = 0;
    for (String location: locations)
       addColumnAndValue(sb, ",location" + i, location, params);
    // now close the thing
    sb.append(") values (?");
    for (i = 1; i<params.size(); i++)
       sb.append(",?");
    sb.append("=");

    // and now sb.toString() will contain valid SQL and the param values for a PreparedStatement will be in params array-list:

    PreparedStatement ps = conn.prepareStatement(sb.toString());
    for (i=0; i<params.size(); i++)
       ps.setObject(i+1, params.get(i));

    ps.executeUpdate(); // voi là!
    ...

}

private void add addColumnAndValue(StringBuilder sb, String columnName, Object value, List<Object> params) {
   sb.append(columnName);
   params.add(value);
}