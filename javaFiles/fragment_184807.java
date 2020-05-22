@Entity
public class User {
    @Id
    private int id;

    private String name;
    ...
}

@Entity
public class Mentee {
    @Id
    private int id;

    @OneToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="MENTOR_ID")
    private Mentor mentor;
    ...
}

@Entity
public class Mentor {
    @Id
    private int id;

    @OneToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToMany(mappedBy="mentor")
    private Collection<Mentee> mentees;
    ...
}