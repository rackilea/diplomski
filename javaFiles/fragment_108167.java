public class StatementPool{

  HashMap<String, Queue<Statement>> statementsPoolMap = ...
  public Statement getStatementByKey(String key){ // you can define keys for queries

     Queue<Statement> queue = statementsPoolMap.get (key); 
     Statement statement = null;
     if(queue.isEmpty()){
       Statement st =  connectionPool.getConnection().prepareStatement();
       ... 
     }else{
       statement = queue.poll();
     }
     ...
     return statement
  }

}