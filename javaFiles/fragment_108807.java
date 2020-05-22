/**
   @throws SQLException If there is an issue with creating the data, or 
                        inserting into the DB
*/
private void storeData(StringData stringData) throws SQLException
{
  ...
  Clob clob = new SerialClob(stringData.toCharArray());
  ...
 }