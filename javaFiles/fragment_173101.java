Listener listener = new Listener() {

    @Override
    public void handleEvent(Event e) {
        if(e.type == SWT.KeyDown||e.type == SWT.KeyUp) {
            System.out.println("" + e.keyCode);
        }
    }
};
display.addFilter(SWT.KeyDown, listener);
display.addFilter(SWT.KeyUp, listener);