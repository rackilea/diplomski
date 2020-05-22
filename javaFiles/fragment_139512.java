public class Event {
    private static String type;
    private static Map<String, VariableObject> properties;

    public static void main(String[] args) {
        Inventory inventory = new Inventory("inventoryName", 13);
        properties.put("Inventory", inventory);
        Shipping shipping = new Shipping("shippingName", true);
        properties.put("Shipping", shipping);
    }
}

public interface VariableObject{
//you can define common methods here if you want
}


public class Inventory implements VariableObject{

    private static String name;
    private static int someNumber;

    public Inventory(String name, int someNumber) {
        this.name = name;
        this.someNumber = someNumber;
    }
}


public class Shipping implements VariableObject{

    private static String name;
    private static boolean someBoolean;

    public Shipping(String name, boolean someBoolean) {
        this.name = name;
        this.someBoolean = someBoolean;
    }
}