Handler handler = mock(Handler.class);
Executor executor = new Executor() {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
};

TestClass testClass = new TestClass(executor, handler);

testClass.doSomething("thisThing");

verify(handler).callHandler();