import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;

import com.google.common.reflect.TypeToken;

class Foo implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator()
    {
        return null;
    }
}

class Bar<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator()
    {
        return null;
    }
}

public class TypeParameterTest
{
    public static void main(String[] args) throws Exception
    {
        Type i0 = getInterface(Foo.class, 0);
        System.out.println("First interface implemented by Foo: "+i0);

        Method method = TypeParameterTest.class.getDeclaredMethod("magic");
        Type returnType = method.getGenericReturnType();

        System.out.println("Magic method return type: "+returnType);

        Type i1 = getInterface(returnType, 0);
        System.out.println("First interface implemented by Bar<String>: "+i1);
    }

    private static Type getInterface(Type type, int interfaceIndex)
    {
        TypeToken<?> typeToken = TypeToken.of(type);
        Class<?> c = typeToken.getRawType();
        Type[] interfaces = c.getGenericInterfaces();
        if (interfaces.length == 0)
        {
            return null;
        }
        Type i = interfaces[interfaceIndex];
        return typeToken.resolveType(i).getType();
    }

    public static Bar<String> magic() { return null; }
}