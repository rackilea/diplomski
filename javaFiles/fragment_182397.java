@Entity 
@Table("INFO_USR_TBL")
public class User {
    @EmbeddedId
    private UserId id;

    @Column(name="firstName") 
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email")
    private String email;

    //setters and getters
}

@Embeddable
public class UserId {
    @Column(name="COMPANY_ID")
    String companyId;
    @Column(name="PERSONAL_ID")
    String personalId;
}