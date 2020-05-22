public class Derived extends Base {
    public static void main(String ... args) throws CloneNotSupportedException {
        System.out.println(new Derived().clone());
    }
}

abstract class Base implements Cloneable {
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}