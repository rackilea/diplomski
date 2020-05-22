import java.util.*;

class YourClass {}
class YourClassEx extends YourClass {}

public class Test {

    public static void x(List<Class<? extends YourClass>> m) {
        // stuff...
    }

    public static void main(String[] argv) {

        List<Class<? extends YourClass>> list = new ArrayList<>();
        list.add(YourClass.class);
        list.add(YourClassEx.class);
        x(list); // compiles fine until here

        list.add(String.class); // doesn't compile
        x(new ArrayList<Class>()); // doesn't compile, either

    }
}