public class User{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;

    @OneToOne(cascade=CascadeType.PERSIST, mappedBy = "user")
    private Account account;
}

public class Account{

    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}