import java.lang.reflect.Method;


public class FooImpl implements Foo<String> {
    public void myMethod(String arg) {
    }

    public static void main(String[] args) throws Exception {
        Class cls = FooImpl.class;
        for (Method method : cls.getMethods()) {
            if (!method.isBridge()) {
                System.out.print(method.getName() + "\t");

                for (Class paramCls : method.getParameterTypes()) {

                    System.out.print(paramCls.getName() + ",");

                }
            }
            System.out.println();
        }
    }
}

interface Foo<T> {
    public void myMethod(T arg);
}