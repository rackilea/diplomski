@Entity(name = "User")
public class User{

    @Id
    @Column(name = "Id")
    private long userId;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "properties")
    private Map<Long, Property> properties= new LinkedHashMap<Long, LkpAIT>();

}