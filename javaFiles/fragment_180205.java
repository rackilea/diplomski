final ResultSetMetaData meta = rs.getMetaData();
final int columnCount = meta.getColumnCount();
final List<List<String>> rowList = new LinkedList<List<String>>();
while (rs.next())
{
    final List<String> columnList = new LinkedList<String>();
    rowList.add(columnList);

    for (final int column = 1; column <= columnCount; ++column) 
    {
        final Object value = rs.getObject(column);
        columnList.add(String.valueOf(value));
    }
}

// add the rowList to the request.