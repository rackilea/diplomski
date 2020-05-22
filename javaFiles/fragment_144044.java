public void doStuff() {
    doMoreStuff(outer -> outer.new MyRunner(), this);
}

public <T> void doMoreStuff(Function<T,? extends TestRunner> s, T context) {
    for(int i = 0; i < 10; i++)
        new Thread(s.apply(context)).start();
}