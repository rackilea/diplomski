getShape().addListener(SWT.KeyUp, new Listener() {
    public void handleEvent(Event event) {
        if (event.stateMask == SWT.CTRL && event.keyCode == 'c') {
            someStuff();
        }
    }});