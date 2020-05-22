private static String spaces(int width) {
    // May be more efficient ways of doing this.
    return String.join("", Collections.nCopies(width, " "));
}

private static String fixedWidth(String s, int width, boolean padLeft) {
    String spaces = spaces(Math.max(0,width-s.length()));
    return (padLeft ? spaces + s : s + spaces).substring(0, width);
}

public void test(String[] args) {
    String[] tests = {"Hello", "Loooooooooooooong!!!"};
    for ( String t: tests) {
        System.out.println(fixedWidth(t,10,false));
        System.out.println(fixedWidth(t,10,true));
    }
}