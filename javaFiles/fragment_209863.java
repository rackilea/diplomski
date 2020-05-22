@PrimaryKeyJoinColumn(name="element_id")
public class User extends Element {

    public User() {
        super();
    }

    public User(String value) {
        super(value);
    }
}