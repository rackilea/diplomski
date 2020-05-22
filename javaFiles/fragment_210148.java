public class MySwingWorker extends SwingWorker<Void, X> { // X - I don't know the type of SaveList elements

    private MyDelegate delegate;

    public MySwingWorker(MyDelegate delegate) {
        this.delegate = delegate;
    }

    protected Void doInBackground() { ... }

    protected void process(SaveList savelist) {
        delegate.doSomethingWith(savelist);
    }
}