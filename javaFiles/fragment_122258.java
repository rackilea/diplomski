@Entity
public class Event {

   @ManyToMany(mappedBy = "eventRegistrations")
   private List<User> userList;

}