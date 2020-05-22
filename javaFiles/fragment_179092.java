@Entity
@Table(schema = "mistergift", name = "users")
public class User {

    /** The user token. */
    @OneToOne
    @JoinColumn(name = "fk_token")
    private Token token;

}

@Entity
@Table(schema = "mistergift", name = "user_token")
public class Token {

    @OneToOne(mappedBy = "token", fetch = FetchType.LAZY)
    private User user;

}