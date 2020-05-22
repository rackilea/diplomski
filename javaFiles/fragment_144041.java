public void doStuff() {
    for (int i = 0; i < 10; i++) {
        doMoreStuff(new MyRunner());
    }
}

public void doMoreStuff(TestRunner t) {
    new Thread(t).start();
}