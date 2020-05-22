user = createUser(username, username, hashedPW.getBytes(), LoginHandler.getInstance()); 


...

User createUser(...){
   return new User(username, username, hashedPW.getBytes(), LoginHandler.getInstance());
}