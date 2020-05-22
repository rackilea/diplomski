public interface A { void m(); }

public class AImpl implements A { public void m() {} }

public class EnqueueProxy implements java.lang.reflect.InvocationHandler {

    private Object obj;

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
            obj.getClass().getClassLoader(),
            obj.getClass().getInterfaces(),
            new EnqueueProxy(obj));
    }

    private EnqueueProxy(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        try {
            MethodQueue mq = ... // get the queue from where you want
            mq.add(new MethodInvocation(obj, m, args)
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        }
            return null;
    }
}