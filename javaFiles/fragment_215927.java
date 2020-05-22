public static Object castToAnotherType(Object param) {
    Object ret = null;
    try {
        ret = (Object) param;
    } catch (ClassCastException e) {
        System.out.print("Exception inside castToAnotherType()");
    }
    return ret;
}