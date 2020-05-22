public static void main(String[] args) {
    String str="Hello 42 World!";
    System.out.println(customSubstringMethod(str, "Hello", "World!"));
}

private static String customSubstringMethod(String str, String start, String stop) {
    return str.substring(str.indexOf(start) + start.length(), str.indexOf(stop));
}