public static void run(Class<?> classType, String methodName, Object[] paramValues, Class[] types) {

    try {
        Object o = classType.newInstance();
        int n = paramValues.length;

        Method[] declaredMethods = classType.getMethods();
        System.out.println(Arrays.toString(declaredMethods));

        System.out.println("------------------------");

        Method method = classType.getDeclaredMethod(methodName, types);
        long s = System.currentTimeMillis();
        method.invoke(o, paramValues);
        long t = System.currentTimeMillis();
        System.out.println("Time Taken : " + (t - s));
    } catch (Exception e) {
        e.printStackTrace();
    }

}