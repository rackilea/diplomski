import java.lang.invoke.*;
import java.util.function.Supplier;

public class LambdaSuper {
    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup l=MethodHandles.lookup();
        MethodType mt=MethodType.methodType(String.class);
        MethodHandle target=l.findSpecial(Object.class, "toString", mt, LambdaSuper.class);
        Supplier<String> s=(Supplier)LambdaMetafactory.metafactory(l, "get",
            MethodType.methodType(Supplier.class, LambdaSuper.class),
            mt.generic(), target, mt).getTarget().invokeExact(new LambdaSuper());
        System.out.println(s.get());
    }

    @Override
    public String toString() {
        return "overridden method";
    }
}