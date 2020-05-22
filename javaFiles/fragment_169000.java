import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;

class EnumTest {
    private static Object[][] parametersProvider() {
        return new Object[][]{
                {TestEnum.class, AnotherTestEnum.class}
        };
    }

    @ParameterizedTest(name = "{index} => enum1={0}, enum2={1}")
    @MethodSource("parametersProvider")
    <T extends Enum<T>, T2 extends Enum<T2>> void testEnum(Class<T> enums1Class, Class<T2> enums2Class) {
        var enums1 = Arrays.stream(enums1Class.getEnumConstants()).map(Enum::name).collect(Collectors.toSet());
        var enums2 = Arrays.stream(enums2Class.getEnumConstants()).map(Enum::name).collect(Collectors.toSet());

        Assertions.assertEquals(enums1, enums2);
    }

    private enum TestEnum {
        A, B
    }

    private enum AnotherTestEnum {
        A, B
    }
}