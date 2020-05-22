@Entity
public class Example {
    @Id long id;
    // ....
    @ElementCollection
    @MapKeyColumn(name="name")
    @Column(name="value")
    @CollectionTable(name="example_attributes", joinColumns=@JoinColumn(name="example_id"))
    Map<String, String> attributes = new HashMap<String, String>(); // maps from attribute name to value

}