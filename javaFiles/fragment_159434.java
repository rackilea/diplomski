public static void main(String[] args){
    String o = Optional.ofNullable("world").map(str -> "hello" + str)
                   .orElseGet(() -> dontCallMe());
    System.out.println(o);
}

private static String dontCallMe() {
    System.out.println("should not have called");
    return "why oh why";
}