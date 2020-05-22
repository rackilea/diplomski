import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        testEnum(TestEnum.class, AnotherTestEnum.class);
    }

    private static <T extends Enum<T>, T2 extends Enum<T2>> void testEnum(Class<T> enums1Class, Class<T2> enums2Class) {
        var enums1 = Arrays.stream(enums1Class.getEnumConstants()).map(Enum::name).collect(Collectors.toSet());
        var enums2 = Arrays.stream(enums2Class.getEnumConstants()).map(Enum::name).collect(Collectors.toSet());

        // compare here
    }

    private enum TestEnum {
        A, B
    }

    private enum AnotherTestEnum {
        A, B
    }
}