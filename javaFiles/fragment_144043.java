public void doStuff() {
    doMoreStuff(MyRunner::new);
}

public void doMoreStuff(Supplier<? extends TestRunner> s) {
    for(int i = 0; i < 10; i++)
        new Thread(s.get()).start();
}