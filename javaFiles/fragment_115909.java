public static void callGetters(Object instance, String... names)
        throws Exception {
    for (String name : names) {
        Method method = instance.getClass().getMethod(name);
        System.out.println(name + ": " + method.invoke(instance));
    }
}

/**
 * @param args
 */
public static void main(String[] args) throws Exception {
    callGetters(new MyObject(), "getName", "getLocation");
}