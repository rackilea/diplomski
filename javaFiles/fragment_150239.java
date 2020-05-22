import java.util.function.Function;

public class Playground {
    public static void main (String[] args) {
        Object o = null;
        System.out.println(o);
        Function<Object, String> toStringFunc = obj -> obj.toString();
        String s = toStringFunc.apply(o);
        System.out.println(s);
    }
}