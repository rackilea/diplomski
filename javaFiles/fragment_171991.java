@Entity
@Table(name = "user_account")
@SecondaryTable(name = "user_detail")
public class User implements Serializable {
    @Id
    private int id;
    private String email;
    private String password;
    @Column(table = "user_detail")
    private String name;
    @Column(table = "user_detail")
    private String city;
}