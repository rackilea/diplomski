@PrimaryKeyJoinColumn(name="element_id")
public class Entity extends Element {
    private String description;


    public Entity() {
        super();
    }

    public Entity(String value, String description) {
        super(value);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}