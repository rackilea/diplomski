void foo() {
    if (somethingbad()) {
        throw new exception();
        bar(); // <-- unreachable code, since throw leaves foo function.
    }
}