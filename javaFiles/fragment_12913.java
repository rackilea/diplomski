void foo() {
    int a = 42;

    if (/*some condition*/) {
        String q = "Life, the Universe, and Everything";

        // 1. Both `a` and `q` are in scope here
        System.out.println(a);
        System.out.println(q);
        if (/*another condition*/) {
            // 2. Both `a` and `q` are in scope here, too
            System.out.println(a);
            System.out.println(q);
        }
    }

    // 3. Only `a` is in scope here
    System.out.println(a);
    System.out.println(q); // ERROR, `q` is not in scope
}