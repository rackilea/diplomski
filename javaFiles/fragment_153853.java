public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    add(list, 1l);

    // On compile time: list contains only String, so no error
    // ON runtime: list has a Number that you added before, and Number -> String throws ClassCastException
    for(String n : list) {
        System.out.println(n);
    }
}

// List here has elements with type Object. you add a Number
// At compile time: you get a warning only
public static void add(List l, Long lNumber ) {
    l.add(lNumber);
}