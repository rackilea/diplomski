public static void main(String[] args) {
    StringBuilder n = new StringBuilder("foo");
    triple(n);
    System.out.println("Hello world! " + n);
}

public static void triple(StringBuilder s) {
    s.append("bar");
    System.out.println("Hello world! " + s);
}