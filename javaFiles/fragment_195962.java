@Entity
public class User extends Model {
    @Id
    public Long id;

    public String email;

    @OneToMany
    public List<Question> questions;
}