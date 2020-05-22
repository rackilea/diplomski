Caller caller;
public start(SomeType1 p1, SomeType2 p2, SomeType3 p3) {
    caller = new Caller(p1, p2, p3);
    ...
    // Do other stuff
}

public Caller getCaller() {
    return caller;
}