public void doStuff() {
    for (int i = 0; i < 10; i++) {
        doMoreStuff(MyRunner::new);
    }
}

public void doMoreStuff(Supplier<? extends TestRunner> s) {
    new Thread(s.get()).start();
}