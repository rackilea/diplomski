//remove row in the ResultSet
 public void removeRow(String empID)
 {
  int rsRow = 0;
  try
  {
   //set cursor to beginning of data set (before first row)
   if(!resultSet.isBeforeFirst())
    resultSet.beforeFirst();
   
   //iterate through resultSet to find matching record with
   //correct employee ID. once found delete row
   while(resultSet.next())
   {
    if(resultSet.getString("EmployeeNo") == empID)
    {
     rsRow = resultSet.getRow();
     
     resultSet.deleteRow();
     System.out.println("User: " + empID + " was deleted from row: " + rsRow);
     break;
    }
   }
   
   resultSet.last();
   numRowCount = resultSet.getRow();
   
   fireTableRowsDeleted(rsRow, rsRow);

//   resultSet.absolute(rsRow);
//   resultSet.deleteRow();
  }
  catch (SQLException e)
  {
   e.printStackTrace();
  }
 }