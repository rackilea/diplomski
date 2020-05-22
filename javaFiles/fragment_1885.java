public class UserList {

 @SerializedName("Users")
 @Expose
 private List<User> users = null;

 public List<User> getUsers() {
   return users;
 }

 public void setUsers(List<User> users) {
   this.users = users;
 }

}