package generics;

import static org.junit.Assert.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import org.junit.Test;

public class HeapTest {

public static class Heap<T> extends ArrayList<String> {}

    @Test
    public void test() {
        Heap h = new Heap<>();
        Type sc = h.getClass().getGenericSuperclass();
        assertTrue(sc instanceof ParameterizedType);

        ParameterizedType pt = (ParameterizedType) sc;
        assertEquals(1, pt.getActualTypeArguments().length);

        assertSame(String.class, pt.getActualTypeArguments()[0]);

        Class<?> clazz              = (Class<?>) pt.getRawType();
        Method method               = clazz.getMethod("get", int.class);

        TypeVariable<?> rt          = (TypeVariable<?>) method.getGenericReturnType();
        String name                 = rt.getName();

        Class<?> arrayListClass     = (Class<?>) pt.getRawType();

        int i = 0;
        for (TypeVariable<?> tv : arrayListClass.getTypeParameters()) {
            if (tv.getName() == name) {
                break;
            }
            i ++;
        }

        Type actualReturnType       = pt.getActualTypeArguments()[i];
        assertSame(String.class, actualReturnType);
    }

}