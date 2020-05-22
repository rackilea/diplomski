import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class NoFinal
{
    public static void main(String[] a) throws Throwable
    {
        FinalInterface o = (FinalInterface) Proxy.newProxyInstance(FinalInterface.class.getClassLoader(), new Class[]{FinalInterface.class}, new InvocationHandler()
        {
            public Object invoke(Object proxy, Method method, Object[] args)
            {
                System.out.println(method);
                return null;
            }
        });
        Method[] methods = FinalInterface.class.getDeclaredMethods();
        methods[0].invoke(o, new Object[]{null});
        methods[1].invoke(o, new Object[]{null});
    }
}