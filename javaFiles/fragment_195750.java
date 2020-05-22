Catch(HibernateException he){
   SQLException sqe = he.getSQLEception();
   String sqlState = sqe.getSQLState();
   if(sqlState.equals("23000"){
       // Handle your exception
   } 
}