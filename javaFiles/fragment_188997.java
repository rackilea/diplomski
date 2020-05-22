public static String foo(String s) {
    // do something 
}

public static String foo(char[] s) {
    return foo(new String(s));
}