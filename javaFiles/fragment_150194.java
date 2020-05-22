final StyledDocument doc = context.openDocument();
NbDocument.runAtomicAsUser(doc, new Runnable() {
    public void run() {
      try {
        doc.insertString(ofset, "New text.", SimpleAttributeSet.EMPTY);
      } catch (Exception e) {
      }
    }
  });