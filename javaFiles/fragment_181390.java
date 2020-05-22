public static HashMap<String, String> createDefaultHashMap() {
    HashMap<String, String> c = new HashMap<String, String>();
    c.put("x", "y");
    c.put("f", "g");
    return c;
}

public Foo(String a, String b) {
    this(a, b, Foo.createDefaultHashMap());;
}