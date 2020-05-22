public class MetafactoryTest {

    public static void main(String[] args) throws Throwable {

        MethodHandles.Lookup caller = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(Object.class);
        MethodType actualMethodType = MethodType.methodType(String.class);
        MethodType invokedType = MethodType.methodType(Supplier.class);
        CallSite site = LambdaMetafactory.metafactory(caller, 
                                                      "get", 
                                                      invokedType, 
                                                      methodType, 
                                                      caller.findStatic(MetafactoryTest.class, "print", actualMethodType), 
                                                      methodType);
        MethodHandle factory = site.getTarget();
        Supplier<String> r = (Supplier<String>) factory.invoke();
        System.out.println(r.get());
    }

    private static String print() {
        return "hello world";
    }    
}