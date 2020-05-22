@Entity
public class UserLegalName extends Model {

    / ..... fields as it is in your post

    public UserLegalName(User user_id, String first_name, String last_name){
        this.user = user_id;
        this.firstName = first_name;
        this.lastName = last_name;
    }
}