@Entity
@Table(name = "group")
public class Group
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

     @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     private Set<Membership> memberships = new HashSet<Membership>(0);
}