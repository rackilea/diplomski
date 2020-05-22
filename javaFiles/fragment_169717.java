@Entity(name = "Users")
public final class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "User_Options"
            , joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user_option", nullable = false)
    private final Set<UserOption> options;

    {
        this.options = EnumSet.noneOf(UserOption.class);
    }

    /* plain getter for id included */

    /* plain getter and setter for name included */

    public Set<UserOption> getOptions() {
        return this.options;
    }

}