public static void uselessMethod(A[] a) {
    /* a is a local variable that makes reference to the object,
       modify the reference only has effect inside this method,
       but modify the array has effects outside the method */
    a = null;
}