import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
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

    private final Map<Title, DoubleProperty> values = new HashMap<>();

    public Client(String name) {
        setName(name);
    }


    public DoubleProperty valueProperty(Title title) {
        // In Java 8, just do
        // return values.computeIfAbsent(title, t -> new SimpleDoubleProperty());

        DoubleProperty value = values.get(title);
        if (value == null) {
            value = new SimpleDoubleProperty();
            values.put(title, value);
        }
        return value ;
    }

    public final double getValue(Title title) {
        return valueProperty(title).get();
    }

    public final void setValue(Title title, double value) {
        valueProperty(title).set(value);
    }

    public Map<Title, DoubleProperty> getValues() {
        return values ;
    }
}