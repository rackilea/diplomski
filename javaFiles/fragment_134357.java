...
}finally{
    try{ 
       resultSet.close();
    }catch( SqlException e ){
       //log error
    }finally{
       try{
          statement.close();
       }catch( SqlException e ){
          //log error
       }finally{
          try{
              connection.close();
          }catch( SqlException e ){
              //log error
          }
       }
    }
}