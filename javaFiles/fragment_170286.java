@MappedSuperclass
public class PropertySuper {
    @Id
    @Column(name="PROPERTY_ID")
    private Long propertyId;

    @Column(name="NAME")
    private String name;

    ...getters and setters...
}