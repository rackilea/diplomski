@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Attribute {
    ...
    private String name;
    private Integer sortOrder;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    ...
    // getters, setters
}