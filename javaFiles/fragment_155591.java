import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StringPropertyTest {

    public static void main(String[] args) {
        StringProperty prop = new SimpleStringProperty();
        prop.addListener((obs, oldValue, newValue) -> {
            System.out.printf("Property changed from %s to %s on thread %s%n", 
                    oldValue, newValue, Thread.currentThread());
        });

        System.out.println("Running on thread "+Thread.currentThread());
        System.out.println("Setting property to \"value\"");
        prop.set("value");

        System.out.println("Setting property to \"new value\" on thread "+Thread.currentThread());
        prop.set("new value");
    }
}