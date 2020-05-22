Profile p = ... //somehow created this
User u = session.get(id,User.class);
u.addProfile(p);
session.saveOrUpdate(u);

p = getLastCreatedChild(u.getProfiles());  // based on the time it is created/ sorted by id you can get the last created child here
p.getKey();// will have the id


-------------User.java------------------

public class User {

   @OneToMany(cascade = CascadeType.ALL)
   private Set<Profile> profiles;
   ....
}