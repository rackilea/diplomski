import java.io.Externalizable ;
import java.io.IOException ;
import java.io.ObjectInput ;
import java.io.ObjectOutput ;

import javafx.beans.property.IntegerProperty ;
import javafx.beans.property.SimpleIntegerProperty ;
import javafx.beans.property.SimpleStringProperty ;
import javafx.beans.property.StringProperty ;

public class Person implements Externalizable {

    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty id = new SimpleIntegerProperty();

    public StringProperty nameProperty() {
        return name ;
    }
    public final String getName() {
        return nameProperty().get();
    }
    public final void setName(String name) {
        nameProperty().set(name);
    }

    public IntegerProperty idProperty() {
        return id ;
    }
    public final int getId() {
        return idProperty().get();
    }
    public final void setId(int id) {
        idProperty().set(id);
    }

    // important: must have a no-arg constructor:
    public Person() { }

    public Person(int id, String name) {
        setId(id);
        setName(name);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // write id then name
        // note we write the contents of the properties, not the properties 
        // themselves, as the properties are not serializable:
        out.writeInt(getId());
        out.writeObject(getName());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // read data back in same order:
        setId(in.readInt());
        setName((String)in.readObject());
    }
}