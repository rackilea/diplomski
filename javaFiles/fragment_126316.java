public static void main(String[] args) throws JAXBException {
    JAXBContext jc = JAXBContext.newInstance(Foo.class);
    JAXBIntrospector is = jc.createJAXBIntrospector();

    // Found objects
    List<Foo.Bar> bars = new ArrayList<>();

    // Object name to look for
    QName barName = new QName("", "bar");

    // Unmarshalled root object to introspect
    Foo target = new Foo(new Foo.Bar());

    // Walk the object graph looking for "bar" elements
    Traverser.traverse(target, o -> {
        if (barName.equals(is.getElementName(o))) {
            bars.add((Foo.Bar) JAXBIntrospector.getValue(o));
        }
    });

    System.out.println(bars);
}

//
// Some test objects
//

@XmlRootElement(name = "foo")
public class Foo {
    private Bar bar;

    public Foo() { }

    public Foo(Bar bar) {
        this.bar = bar;
    }

    @XmlElement(name="bar")
    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    @XmlRootElement(name="bar")
    public static class Bar {
        String name = "kate";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Bar{name='" + name + '\'' + '}';
        }
    }
}