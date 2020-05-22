@Entity
public class User extends Model{

    / ..... fields as it is in your post

    public User(String user_id){
        this.userId = user_id;
    }

    public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class)

    public static User findByUserID(String user_id){

       /* Your models already in bi-directional relationship, so there is no need for external `fetch`, You can directly get `UserLegalName` object from `User`
               model if there is any match found on `UserLegalName` for the input.  */

       return find.where().eq("userId",user_id).findUnique();
    }
}