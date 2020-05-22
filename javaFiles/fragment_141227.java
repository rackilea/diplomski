@Override
    public void insertUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        lastChange++;
        SwingUtilities.invokeLater(() -> {
            if (lastNotifiedChange != lastChange) {
                lastNotifiedChange = lastChange;
                changeListener.stateChanged(new ChangeEvent(text));
            }
        });
    }
};
text.addPropertyChangeListener("document", (PropertyChangeEvent e) -> {
    Document d1 = (Document)e.getOldValue();
    Document d2 = (Document)e.getNewValue();
    if (d1 != null) d1.removeDocumentListener(dl);
    if (d2 != null) d2.addDocumentListener(dl);
    dl.changedUpdate(null);
});
Document d = text.getDocument();
if (d != null) d.addDocumentListener(dl);