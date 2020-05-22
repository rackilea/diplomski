@Entity
@Table(name = "USERS")
public class User {    

    @Column(name = "STATE")
    private int state=State.ACTIVE.getState();

    @Transient
    private String stateName;