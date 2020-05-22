public class MyClass extends AbstractMyClass {

    public MyClass(String name) {
        super(name);
    }

    @Override
    public String getSpecialVersion() {
        return name + name;
    }

}