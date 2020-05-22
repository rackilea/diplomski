private static void change(String in) {
    in = in + " World"; // <-- modifies in here, can't change caller's reference.
}

private static void change(StringBuilder in) {
    in.append(" World"); // <-- uses reference from caller.
}

public static void main(String[] args) {
    String str = "Hello";
    StringBuilder sb = new StringBuilder(str);
    change(str);
    change(sb);
    System.out.println("one: " + str);
    System.out.println("two: " + sb);
}