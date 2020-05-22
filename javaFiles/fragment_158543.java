final int cnt = rs.getMetaData().getColumnCount();

for (int i=0; i<cnt; ++i)
{
    columns.put("id", Integer.toString(i));
    columns.put("name", rs.getMetaData().getColumnName());
    columns.put("type", rs.getMetaData().getColumnClassName(i));
    columns.put("nullable", Integer.toString(rs.getMetaData().isNullable(i)));

    s.add(columns);
}