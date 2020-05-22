// getting the synthetic static lambda method
public static Method getLambdaMethod(SerializedLambda lambda) throws Exception {
    String implClassName = lambda.getImplClass().replace('/', '.');
    Class<?> implClass = Class.forName(implClassName);

    String lambdaName = lambda.getImplMethodName();

    for (Method m : implClass.getDeclaredMethods()) {
        if (m.getName().equals(lambdaName)) {
            return m;
        }
    }

    throw new Exception("Lambda Method not found");
}