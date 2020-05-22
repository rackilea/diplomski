try{
if(resultset.next())
 return true;
return false; 
}
catch(Exception e){}
finally{
   sql.close();
   resultSet.close();
}