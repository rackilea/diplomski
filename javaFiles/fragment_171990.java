@Entity
public class UserAccount implements Serializable {
    @Id
    @OneToOne(mappedBy="userAccount")
    private UserDetail userDetails;
}