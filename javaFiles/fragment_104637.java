public String backTrace(Throwable e) {
    StackTraceElement[] stack = e.getStackTrace();
    String trace = "";
    for (int i=0; i<stack.length; ++i) {
        trace += stack[i].toString() + "\n";
    }
    return trace;
}