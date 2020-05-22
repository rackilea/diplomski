Foobar foobarA = ...;
Foobar foobarB = ...;
Object lock = new Object();

synchronized(lock) {
    if (foobarA.equals(foobarB)) {
        doSomethingThatOnlyMakesSenseIfTheyAreEqual(...);
    }
}