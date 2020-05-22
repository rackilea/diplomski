int doSomething(int value) {
    int i;
    if (value > 10) {
        i = value;
    }

    //
    // This line will throw a compile-time error that 
    // `i` may not have been initialized.
    //
    return i; 
}