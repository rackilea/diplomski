import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Title {
    private final StringProperty name = new SimpleStringProperty(this, "name");
    public final String getName() {
        return name.get();
    }
    public final void setName(String name) {
        this.name.set(name);
    }
    public StringProperty nameProperty() {
        return name ;
    }

    public Title(String name) {
        setName(name);
    }
}