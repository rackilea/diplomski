@Entity(name = "ROLES")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Role implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    int id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    User user;

    ...
}