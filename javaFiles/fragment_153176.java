@Entity
public class Item implements Serializable {
    @Id
    public Long id;

    @Unowned
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "properties")
    public Set<Property> properties = new HashSet<Property>();

    @ElementCollection
    public Set<Long> propIds = new HashSet<Long>();
}

@Entity
public class Property implements Serializable {
    @Id
    public Long id;
    public String value;
}