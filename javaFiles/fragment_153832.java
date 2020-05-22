public void doSomething() {
    if (true) {
        return;
    }
    // All code below here is considered unreachable code
    doSomething()
}