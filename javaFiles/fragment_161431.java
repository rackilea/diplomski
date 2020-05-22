import java.lang.reflect.*;

/**
 * Decorates a HammerListener instance, adding BEFORE/AFTER 
 * log messages around all methods exposed in the HammerListener interface.
 */

public class HammerListenerDecorator implements InvocationHandler {

    private final HammerListener delegate;

    static HammerListener newInstance(HammerListener delegate) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return (HammerListener)Proxy.newProxyInstance(cl, new Class[]{HammerListener.class},
            new HammerListenerDecorator(delegate));
    }

    private HammerListenerDecorator(HammerListener delegate) {
        this.delegate = delegate;
     }

     @Override
     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         logger.info("BEFORE " + method.getName() + " {{{" + argsToString(args) + "}}}");
         Object rtn = method.invoke(delegate, args);
         logger.info("AFTER " + method.getName());
         return rtn;
     }

     private String argsToString(Object[] args) {
         StringBuilder sb = new StringBuilder();
         for (Object o : args) {
             sb.append(String.valueOf(o)).append(" ");
         }
         return sb.toString();
     }
}