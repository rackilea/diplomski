import java.util.*;

class Foo{}
class Bar extends Foo{}
class Z{}
public class FooBar2{ 
    public static void main(String[] args) {
        List<Foo> list = new ArrayList<>();
        list.add(new Foo());
        list.add(new Bar());

        // Compile error
//        list.add(new Z());

        // Subterfuge
        ((List) list).add(new Z());
    }
}