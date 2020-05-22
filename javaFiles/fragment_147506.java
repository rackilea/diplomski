while (resultSet.next()) 
{
    String tableName = resultSet.getString(3);
    System.out.println(tableName);
    table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(resultSet));
}