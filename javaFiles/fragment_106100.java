public class User
...
public void addGroup(Group g){
   groups.add(g);
   g.addUser(this);
}