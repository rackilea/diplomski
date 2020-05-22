@Entity(name = "User")
public class User{

    @Id
    @Column(name = "Id")
    private long userId;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "properties")
    private Map<Long, Property> properties= new LinkedHashMap<Long, LkpAIT>();

}