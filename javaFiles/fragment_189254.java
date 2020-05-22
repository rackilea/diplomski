static void m(List<String> list) { }

public static void main(String args[]) {

    m(Collections.emptyList());         // error
    m(Collections.<String>emptyList()); // valid
}