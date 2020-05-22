final AtomicInteger resultAtomicInteger = new AtomicInteger();
Display.getCurrent().syncExec(new Runnable() { 
    public void run() {
        MessageBox mb = /* ... */;
            /* set up messagebox */
        resultAtomicInteger.set(mb.open());
}});
if (SWT.OK == resultAtomicInteger.get()) { /* ... */ }