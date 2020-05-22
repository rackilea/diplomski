public class MyMain {

    public static void main(String[] args) throws Throwable {
        GetterFunction getterFunction;
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(String.class, Person.class);
        final CallSite site = LambdaMetafactory.metafactory(lookup,
                "invoke",
                MethodType.methodType(GetterFunction.class),
                methodType,
                lookup.findVirtual(Person.class, "getName", MethodType.methodType(String.class)),
                methodType);
        getterFunction = (GetterFunction) site.getTarget().invokeExact();
        System.out.println(getterFunction.invoke(new Person("Ann")));
    }

    @FunctionalInterface
    interface GetterFunction {

        String invoke(final Person callable);
    }

}