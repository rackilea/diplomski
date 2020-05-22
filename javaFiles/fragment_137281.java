import java.util.Arrays;
import static java.lang.System.out;

public class Clazz1 {

    public enum test
    {
    a, b, c, d, e, f;
    };

    public static int test = 10;


    public static void main(String[] args) {
    Class<?> ec = Clazz1.test.class;
    out.format("Name: %s, constants: %s%n\n", ec.getName(), 
        Arrays.asList(ec.getEnumConstants()));
    }
}