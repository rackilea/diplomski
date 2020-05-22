@Entity
@Table(name = "USERS")
public class User{
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTIFIER", nullable = false)
        private Long identifier;

    @JoinColumn(referencedColumnName = "PASSWORDS.USERIDENTIFIER", name="USERS.IDENTIFIER")
    @OneToOne
    private Password password;

    // getters, setters, and other User related information such as username
}

@Entity
@Table(name = "PASSWORDS")
public class Password{
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTIFIER", nullable = false)
        private Long identifier;

    @JoinColumn(name = "USERIDENTIFIER", referencedColumnName = "IDENTIFIER", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
        private User useridentifier;
    //getters, setters, and other password related fields such as the password it's self
}