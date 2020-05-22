...
MyHandler handler = new MyHandler();
// catch the control-c signal, "TERM" is another common kill signal
Signal.handle(new Signal("INT"), handler);
...

private static class MyHandler implements SignalHandler {
    @Override
    public void handle(Signal arg0) {
        // interrupt your threads
        // clean up stuff
        // set shutdown flags
        // ...
    }
}