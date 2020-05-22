public class Bar {

private double someValue;

public double getSomeValue() {
    return someValue;
}

public void setSomeValue(double someValue) {
    this.someValue = someValue;
}

}

public class Foo {

private String value;
private double primitiveDouble;
private Bar bar;

public Bar getBar() {
    return bar;
}

public double getPrimitiveDouble() {
    return primitiveDouble;
}

public String getValue() {
    return value;
}

public void setBar(Bar bar) {
    this.bar = bar;
}

public void setPrimitiveDouble(double primitiveDouble) {
    this.primitiveDouble = primitiveDouble;
}

public void setValue(String value) {
        this.value = value;
    }
}