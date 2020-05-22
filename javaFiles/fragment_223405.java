public class MyClass implements IMyClass {

    public String name;

    public MyClass(String name) {
         this.name = name;
    }

    @Override
    public String getSpecialVersion() {
        return name + name;
    }

}