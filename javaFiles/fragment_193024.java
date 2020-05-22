@Entity
@Table(name="tblUser")
@IdClass(UserId.class)
public class User ... {

    @Id
    private String username;

    @Id
    private Integer countyId;

}