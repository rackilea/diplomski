public static void main(final String args[]) {
    final List<String> myStrings = new LinkedList<>();
    final String s = "<Java><SQL>";
    myStrings.addAll(split(s));
    System.out.println(myStrings);
    myStrings.addAll(split(s));
    System.out.println(myStrings);
    myStrings.addAll(split(s));
    System.out.println(myStrings);
    myStrings.addAll(split(s));
    System.out.println(myStrings);
}

public static List<String> split(final String in) {
    return Arrays.asList(in.replaceAll("(?:^<)|(?:>$)", "").split("><"));
}