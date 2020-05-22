@Entity
@Table
public class Foo {
    // ID, other properties, ...

    @ElementCollection
    @MapKeyColumn(name="key", length=100)
    @Column(name="value", length=512)
    @CollectionTable(name="properties", joinColumns=@JoinColumn(name="foo_id"))
    private Map<String, String> properties;
}