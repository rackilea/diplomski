@Entity
public class Root {
    @Id
    private Long code;

    private String value;

    @ElementCollection
    @MapKeyColumn(name = "keyValue")
    private Map<String, Item> items;
}