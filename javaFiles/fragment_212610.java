@Entity
public class User implements Serializable{

    @OneToMany(mappedBy = "user")
    private List<Profile> profiles = new LinkedHashSet<Profile>();
//...other stufs..
.
.
}