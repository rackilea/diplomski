ResultSet rs=getAllDataInResultSet();//this method will return from stored procedure
List<int> resultList=new ArrayList<>();
while(rs.next()){
      int  colB=rs.getInt(2);
      if(colB==2){
       resultList.add(rs.getInt(4));
      }
}
logger.debug(resultList); //logging the final Result list