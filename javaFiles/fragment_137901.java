@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

}

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @Column(name = "CAR_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "FIRST_USER_ID", referencedColumnName = "USER_ID")
    private User firstUser;

    @ManyToOne
    @JoinColumn(name = "SECOND_USER_ID", referencedColumnName = "USER_ID")
    private User secondUser;

}