while (VendorItems_RSet.next()) 
{
  for(int i=1;i<=numberOfColumns;i++)
  {   
     String columnName = VendorItems_RSet_metaData.getColumnName(i);
     String tax_name = VendorItems_RSet.getString(columnName);
     System.out.println(tax_name); 
  }         
}