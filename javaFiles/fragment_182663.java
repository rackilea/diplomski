@Entity
public class Multiple extends Attribute {
    ...
    @OneToMany(mappedBy = "attribute")
    private List<AttributeOption> options;
    // getters, setters
    ...
}