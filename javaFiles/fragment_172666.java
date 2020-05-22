ResultSet res = objBBDD.sentencia.executeQuery(sql);

 while(res.next){
  Director direc = new Director();// Declare Director instance here.
   .....
  list.add(direc);
 }