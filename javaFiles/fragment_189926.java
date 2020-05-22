public static Object handle(Object val) {
    System.out.println("T");
    return val;
}

public static String handle(String val) {
    System.out.println("T extends String");
    return val;
}