c.getDisplay().asyncExec(new Runnable() {
    @Override
    public void run() {
        if (c.isDisposed()) return;
        // ...
    }
});