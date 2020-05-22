import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main
{
    public static void main(final String[] argv)
        throws Exception
    {
        final Class<?> clazz;

        clazz = Class.forName("NotPrivate$A");        

        for(final Method method : clazz.getDeclaredMethods())
        {
            if(method.isSynthetic())
            {
                final Constructor constructor;
                final Object instance;

                constructor = clazz.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
                instance = constructor.newInstance();
                method.setAccessible(true);
                method.invoke(null, instance);
            }
        }
    }
}