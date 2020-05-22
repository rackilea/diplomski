import java.lang.invoke.*;
import java.lang.ref.WeakReference;

public class LambdaClassUnloading {
    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t=MethodType.methodType(void.class);
        Runnable r=(Runnable)LambdaMetafactory.metafactory(l, "run",
            MethodType.methodType(Runnable.class), t,
            l.findStatic(LambdaClassUnloading.class, "testMethod", t), t)
            .getTarget().invokeExact();
        System.out.println("generated "+r);
        r.run();
        WeakReference<Class<?>> ref=new WeakReference<>(r.getClass());
        r=null;
        while(ref.get()!=null) System.gc();
        System.out.println("class collected");
    }
    private static void testMethod() {
        System.out.println("testMethod() called");
    }
}