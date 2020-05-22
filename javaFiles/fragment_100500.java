@Entity
@Access(AccessType.PROPERTY)
public class Person {

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty surname = new SimpleStringProperty();

    @Column("name") // not needed, just illustrating the annotations, if needed, go here
    public String getName() {
        return nameProperty().get();
    }

    public void setName(String name) {
        nameProperty().get(name);
    }

    public StringProperty nameProperty() {
        return name ;
    }

    // etc...
}