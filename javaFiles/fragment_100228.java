@Entity
public class EntityA {
    private @Id Integer id;
    private Integer someValue;
    @ElementCollection
    List<Integer> listOfValues;

    public EntityA() { }

    public EntityA(Integer id, Integer someValue, List<Integer> listOfValues) {
        this.id = id;
        this.someValue = someValue;
        this.listOfValues = listOfValues;
    }
}