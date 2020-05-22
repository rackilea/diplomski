public static void nullify(Object obj) {
    obj = null;
}

public static void main(...) {

    String x = "Hello";        
    nullify(x);

    System.out.println(x);
}