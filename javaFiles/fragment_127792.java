public void myMethod(VarArgsRunnable2 runnable, Object arg0, Object arg1) {
    myMethod((VarArgsRunnable)runnable, combine(arg0, arg1));
}

private static Object [] combine(Object ... values) {
    return values;
}