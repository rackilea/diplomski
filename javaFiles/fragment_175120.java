public class UserResource {
  private UserService userService;

  @Inject
  public UserResource(UserService userService) {
    this.userService = userService;
  }

  public boolean createUser(User user) {
    DbResponse res = userService.addUser(user);
    if(res.isSuccess){
      return true;
    }else{
      return false;
    }
  }
}