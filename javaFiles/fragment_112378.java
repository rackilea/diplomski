abstract class Base {
    abstract String Description();
    String toString() { return "Base"; }
}
class Derived extends Base {
    String Description() { return "Derived description"; }
    String toString() { return "Derived"; }

    static void use(Base instance) {
        System.out.println(instance.toString());
        System.out.println(instance.Description());
    }
}