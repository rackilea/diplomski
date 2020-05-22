class Base {
    private final String name;
    public String getName() {return name;}
    public Base(String name) {
        this.name = name;
    }
    public Base(Base b) {
        this(b.getName());
    }
}
class Derived extends Base {
    public String getName() {
        return "["+super.getName()+"]";
    }
    public Derived(String name) {
        super(name);
    }
    public Derived(Derived d) {
        this(d.getName());
    }
}