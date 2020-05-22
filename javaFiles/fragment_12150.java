@Entity
@Access(AccessType.PROPERTY)
public class Person implements Serializable {

    private transient StringProperty name = new SimpleStringProperty() ;

    public StringProperty nameProperty() {
        return name ;
    }

    public String getName() {
        return nameProperty().get();
    }

    public void setName(String name) {
        nameProperty().set(name);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject(getName());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.name = new SimpleStringProperty((String) s.readObject());
    }
}