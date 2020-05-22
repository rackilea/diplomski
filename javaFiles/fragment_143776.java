interface I1 {
    void test();
}

class C1 implements I1 {
    public void test() {
        System.out.println("test");
        throw new RuntimeException();
    }
}

class ExceptionHandler implements InvocationHandler {
    Object obj;

    ExceptionHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            // need a workaround for primitive return types
            return null;
        }
    }

    static <T> T proxyFor(Object obj, Class<T> i) {
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[] { i },
                new ExceptionHandler(obj));
    }
}

public class Test2 {

    public static void main(String[] args) throws Exception {
        I1 i1 = ExceptionHandler.proxyFor(new C1(), I1.class);
        i1.test();
    }
}