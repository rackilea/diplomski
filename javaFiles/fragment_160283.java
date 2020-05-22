@Entity
public class Customer
{
   private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

   private String name;

   private String comment;

   @JsonProperty(access = JsonProperty.Access.READ_ONLY)
   @Access(AccessType.PROPERTY)
   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   private Set<Address> addresses = new HashSet<>();
}