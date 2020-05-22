public static String getAt(String st, int pos) {
    String[] tokens = st.split(",");
    return tokens[pos-1];
}

public static void main(String[] args) {
    String st = "one,two,three,four";
    System.out.println(getAt(st, 1)); // prints "one"
    System.out.println(getAt(st, 2)); // prints "two"
    System.out.println(getAt(st, 3)); // prints "three"
}