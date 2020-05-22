ResultSetMetaData  VendorItems_RSet_metaData = VendorItems_RSet.getMetaData(); 
int numberOfColumns = VendorItems_RSet_metaData .getColumnCount(); 
for(int i=1;i<=numberOfColumns;i++)
{   
   String columnName = VendorItems_RSet_metaData.getColumnName(i);
}