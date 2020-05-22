void myMethod(String arg1) {
    if (myMethodInternal(arg1)) {
        doNormalThing();
    }
}

private boolean myMethodInternal(String arg1) {
    SomeObject foo = getSomeObject(arg1);
    if (foo == null) {
        return true;
    }

    SomeOtherObject bar = goo.getSomeOtherObject();
    if (bar == null) {
        return true;
    }
    // etc

    if (baz.exitEarly()) {
        foo.recordEarlyExit(baz.getName());
        return false;
    }
    return true;
}