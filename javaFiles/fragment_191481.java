@Entity
public class User {

     @Id private String username;
     private String password;
     /*getters setters ommited*/
}

@Api(name = "userapi", version = "v1", description = "userapi")
public class UserService {

     static{
         ObjectifyService.register( User.class );
     }

     @ApiMethod(name = "create")
     public User createUser(@Named("username") String username,     
                                    @Named("password") String password){
         User user = new User();
         user.setUsername(username);
         user.setPassword(password);
         ofy().save().entity(user);  
         return user;
    }

    @ApiMethod(name = "get")
    public User getUser(@Named("username") String username, 
                                  @Named("password") String password){
           User user = ofy().load().key(Key.create(User.class, 
                                                  username)).now(); 
           return user;
    }
}