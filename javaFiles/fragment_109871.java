public synchronized static void setCounter(int counter) {
    Foo.counter = counter;
}

public void bar(int counter) {
    setCounter(counter);
}