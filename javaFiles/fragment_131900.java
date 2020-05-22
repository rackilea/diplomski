public Something createSomething() {
    if(someStatement) {
         return new Something();
    } else {
        return new SomethingElse();
    }
}

public Something someMethod() {
    Something something = createSomething();
    // Do the thing that always needs to be done
    return something;
}