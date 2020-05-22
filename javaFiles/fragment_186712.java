@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class MyClass {

    private double value;
    private Foo foo;

    public MyClass() {
    }
    public MyClass(double value, Foo foo) {
        this.value = value;
        this.foo = foo;
    }

    public void setValue(double value){this.value = value;}
    public double getValue(){return this.value;}

    public void setFoo(Foo foo){this.foo = foo;}
    @XmlElement() public Foo getFoo(){return this.foo;}

    @XmlElement(name = "value")
    public Double getXmlValue() {
        if (Double.isFinite(this.value))
            return this.value;
        return null;
    }
}

public class Foo {
    @XmlElement()
    public String getBar() { return "Test"; }
}