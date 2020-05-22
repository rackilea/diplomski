@Entity
public class AttributeOption {
    ... 
    private String name;
    private Integer sortOrder
    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;
    // getters, setters
    ...
}