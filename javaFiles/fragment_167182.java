package playtest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import static junit.framework.Assert.*;

interface MyInterface {
    void run();
    void about();
    void run(String j);
}


public class TestProxyClass {
    @Test
    public void testDeclaringClass() throws Exception {
        final Map<Method, Runnable> actions = new HashMap<Method, Runnable>();

        actions.put(MyInterface.class.getMethod("run"), new Runnable() {

            @Override
            public void run() {
                System.out.println("run");
            }

        } );
        actions.put(MyInterface.class.getMethod("run", String.class), new Runnable() {

            @Override
            public void run() {
                System.out.println("run string");
            }

        } );
        actions.put(MyInterface.class.getMethod("about"), new Runnable() {

            @Override
            public void run() {
                System.out.println("about");
            }

        } );

        MyInterface face = (MyInterface) Proxy.newProxyInstance(getClass().getClassLoader(), 
                new Class<?>[] { MyInterface.class }, new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method,
                            Object[] args) throws Throwable {
                        actions.get(method).run();
                        return null;
                    }

                } );

        face.run();
        face.about();
        face.run("Hello");
    }
}