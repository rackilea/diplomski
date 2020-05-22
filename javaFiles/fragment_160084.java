@QueryParam("user") @DefaultValue("__DEFAULT")



class User{
...
 public static User valueOf(String user){
   if(user == null||"__DEFAULT".equals(user) return DEFAULT_USER;
   return dao.findById(user);
 }    
}