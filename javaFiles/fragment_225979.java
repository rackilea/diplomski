import java.lang.reflect.Constructor;
import java.util.List;

public class Test {

    public static void main(String[] args) throws ReflectiveOperationException {
        Class<?> clazz = Class.forName("java.util.Collections$EmptyList");
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        List<?> emptyList = (List<?>) constructor.newInstance();

        emptyList.get(0);
    }
}