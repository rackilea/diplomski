try {
    baz();
    bar();
    foo(myInput);
} catch (IllegalArgumentException e) {
    // Where did this come from!?
    // It could have come from foo(myInput), or baz(), or bar(),
    // or some method that any of them invoked, or really anywhere
    // in that stack.
    // It could be something totally unrelated to user input, just
    // a bug somewhere in my code.
    // Handle it somehow...
}