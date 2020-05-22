@Entity
public class Car {
    ...
    @OneToMany(mappedBy = "car")
    private List<Attribute> attributes;
    ...
    // getters, setters
}