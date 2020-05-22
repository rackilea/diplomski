import java.util.HashMap;
import java.util.Map;

class A {
    String name;
    Integer number;

    public A(String name, Integer number) {
    super();
    this.name = name;
    this.number = number;
    }

}

class B {
    String name;
    Integer number;

    public B(String name, Integer number) {
    super();
    this.name = name;
    this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
    if (obj instanceof B) {
        return obj == this || (name.equals(((B) obj).name) && number.equals(((B) obj).number));
    }
    return false;
    }

    @Override
    public int hashCode() {
    return name.hashCode() + number.hashCode();
    }
}

public class TestHashMap {

    public static void main(String... args) {
        A a1 = new A("a", 1);
        A anotherA1 = new A("a", 1);

        Map<A, String> as = new HashMap<A, String>();

        as.put(a1, "a1");

        System.out.println(as.get(anotherA1)); // prints null

        B b1 = new B("b", 1);
        B anotherB1 = new B("b", 1);

        Map<B, String> bs = new HashMap<B, String>();

        bs.put(b1, "b1");

        System.out.println(bs.get(anotherB1)); // prints b1

    }

}