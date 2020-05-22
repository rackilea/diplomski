public static Action resultOfActMethod(String objclass){    
    Class clazz = Class.forName(objclass);
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    MethodHandle mh = lookup.findConstructor(clazz, MethodType.methodType(void.class, String.class));
    Function<String, Action> constructor = (Function<String, Action>)LambdaMetafactory.metafactory(lookup, "apply",MethodType.methodType(Function.class),
                        mh.type().generic(), mh, mh.type()).getTarget().invokeExact();
    Action action = constructor.apply(objclass);
    return action;
}