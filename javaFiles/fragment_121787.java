import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public void method1(@Constraint int i) {}
    public void method2(String id, @Constraint float f) {}
    public void method3(int i, @Constraint List<String> strings, @Constraint String s) {}
    public void method4(int i, @Constraint Set<Integer> numbers, float f, boolean b) {}
    public void method5(boolean b, String s, @Constraint String s2, float f, int i) {}
    public void notIntercepted(boolean b, String s, String s2, float f, int i) {}

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("foo");
        strings.add("bar");
        Set<Integer> numbers = new HashSet<Integer>();
        numbers.add(11);
        numbers.add(22);
        numbers.add(33);

        Application app = new Application();
        app.method1(1);
        app.method2("foo", 1f);
        app.method3(1, strings, "foo");
        app.method4(1, numbers, 1f, true);
        app.method5(false, "foo", "bar", 1f, 1);
        app.notIntercepted(false, "foo", "bar", 1f, 1);
    }
}