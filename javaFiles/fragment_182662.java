@Entity
public class Single extends Attribute {
    ...
    @OneToMany(mappedBy = "attribute")
    private List<AttributeOption> options;
    // getters, setters
    ...
}