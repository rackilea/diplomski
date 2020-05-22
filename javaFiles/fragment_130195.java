import annotations.Descriptor;
import annotations.Property;

@Descriptor(displayName = "Example Bean", shortDescription = "This is an example bean")
public class ExampleBean {

    @Property(displayName = "Integer Value", shortDescription = "This is an integer value")
    int integerValue;

    @Property(displayName = "Double Value", shortDescription = "This is a double value")
    double doubleValue;

    @Property(displayName = "String Value", shortDescription = "This is a string value")
    String stringValue;

    public int getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

}