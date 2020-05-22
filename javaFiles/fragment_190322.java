TextViewer viewer = new TextViewer();
viewer.getDocument().addDocumentListener(new IDocumentListener() {
    @Override
    public void documentChanged(final DocumentEvent event) {
        // use event.fText, event.fOffset etc to apply changes to document
        ...
    }
});