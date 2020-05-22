import java.util.Arrays;

public class Test {

    public static void main(String... args) {
        String[] strings = new String[] { "foo", "bar" };
        System.out.println(Arrays.toString(strings)); // [foo, bar]
        changeValue(strings);
        System.out.println(Arrays.toString(strings)); // [foo, foo]
    }

    public static void changeValue(String[] strings) {
        strings[1] = "foo";
    }

}