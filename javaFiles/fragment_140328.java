public static void main( String[] args ) {
    // rest of String contains more numbers as an edge case
    String input = "23 14 this is a random 45 67 string";
    String remains = input.replaceAll("^(\\d+\\s*){2}","");
    System.out.println( remains );
}