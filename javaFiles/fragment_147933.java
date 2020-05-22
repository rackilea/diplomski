display.addFilter(SWT.KeyDown, new Listener() {
    public void handleEvent(Event e) {
        if (e.character == 32) {
            System.out.printf("Space detected %s\n", e);
        }
    }
});

Button b1 = new Button(shell, SWT.PUSH);
b1.addSelectionListener(new SelectionAdapter() {
    @Override
    public void widgetSelected(SelectionEvent se) {
        System.out.printf("Button pressed %s\n", se);
    }
});

b1.addTraverseListener(new TraverseListener() {
    @Override
    public void keyTraversed(TraverseEvent te) {
        System.out.printf("Traverse detected %s\n", te);
        te.doit = true;
    }
});