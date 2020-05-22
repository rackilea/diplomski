// sample how to use
public static interface SomeFunction<I, O> extends java.io.Serializable {

    List<O> applyTheFunction(Set<I> value);
}

public static void main(String[] args) throws Exception {

    SomeFunction<Double, Long> lambda = (set) -> Collections.singletonList(set.iterator().next().longValue());

    SerializedLambda sl = getSerializedLambda(lambda);      
    Method m = getLambdaMethod(sl);

    System.out.println(m);
    System.out.println(m.getGenericReturnType());
    for (Type t : m.getGenericParameterTypes()) {
        System.out.println(t);
    }

    // prints the following
    // (the method) private static java.util.List test.ClassWithLambdas.lambda$0(java.util.Set)
    // (the return type, including *Long* as the generic list type) java.util.List<java.lang.Long>
    // (the parameter, including *Double* as the generic set type) java.util.Set<java.lang.Double>