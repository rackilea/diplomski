final AtomicReference<String> ref = new AtomicReference<String>();
final Runnable runnable = new Runnable() {
    public void run() {
        ref.set("Hello world");
    }
};

runnable.run();
System.out.println(ref.get());