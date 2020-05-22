ResultSetMetaData metaData = resultSet.getMetaData();
int count = metaData.getColumnCount(); //number of column
String columnName[] = new String[count];

for (int i = 1; i <= count; i++)
{
   columnName[i-1] = metaData.getColumnLabel(i);
   System.out.println(columnName[i-1]);
}