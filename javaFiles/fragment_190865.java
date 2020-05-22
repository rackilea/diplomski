import java.util.Comparator;

public class MyObject {
    private final int intProperty;
    private final String stringProperty;

    public MyObject(int intProperty, String stringProperty) {
        this.intProperty = intProperty;
        this.stringProperty = stringProperty;
    }

    public int getIntProperty() {
        return intProperty;
    }

    public String getStringProperty() {
        return stringProperty;
    }

    public static final Comparator<MyObject> intComparator = new Comparator<MyObject>() {
        @Override
        public int compare(MyObject o1, MyObject o2) {
             return o1.getIntProperty() == o2.getIntProperty() ? 0 : (o1.getIntProperty() < o2.getIntProperty() ? -1 : 1);
        }
    };

    public static final Comparator<MyObject> stringComparator = new Comparator<MyObject>() {
        @Override
        public int compare(MyObject o1, MyObject o2) {
            return o1.getStringProperty().compareTo(o2.getStringProperty());
        }
    };
};