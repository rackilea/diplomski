public class ChildClass extends SuperClass {
    private String c;
    private String d;

    public SuperClass getSuperClassInstance() {
        SuperClass sc = new SuperClass();
        sc.a = this.a; //or use getters/setters
        sc.b = this.b; //you might need to deep clone objects
        return sc;
    }
}