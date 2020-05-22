new Text(popup, SWT.NONE).addTraverseListener(new TraverseListener() {
    @Override
    public void keyTraversed(TraverseEvent e) {
        if(e.detail == SWT.TRAVERSE_ESCAPE) {
            e.doit = false;
        }
    }
});