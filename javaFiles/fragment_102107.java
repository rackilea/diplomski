final Object anonymous = obj; // won't work if obj isn't initialized
Runnable run = new AnonymousRunnable(anonymous);
...
class AnonymousRunnable implements Runnable {
    public AnonymousRunnable(Object val) {
        this.someHiddenRef = val;
    }
    private final Object someHiddenRef;
    public void run() {
        someHiddenRef.toString(); 
    }
}