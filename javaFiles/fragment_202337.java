void f() {
    int x = 42;
    if (true) {
        int x = 13; // COMPILER ERROR
        ...
    }
}