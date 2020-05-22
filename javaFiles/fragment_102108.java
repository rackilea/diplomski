final Foo anonymous = Foo.this; // you're in the Foo constructor so this is valid reference to a Foo instance
Runnable run = new AnonymousRunnable(anonymous);
...
class AnonymousRunnable implements Runnable {
    public AnonymousRunnable(Foo foo) {
        this.someHiddenRef = foo;
    }
    private final Foo someHiddenFoo;
    public void run() {
        someHiddenFoo.obj.toString(); 
    }
}