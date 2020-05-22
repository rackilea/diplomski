public class Group
...
public void addUser(User u){
   users.add(u);
   u.addGroup(this);
}