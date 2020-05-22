@Entity
@Table(schema = "mistergift", name = "users")
public class User {

    /** The user token. */
    @OneToOne(mappedBy = "user")
    private Token token;

}

@Entity
@Table(schema = "mistergift", name = "user_token")
public class Token {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
    private User user;

}