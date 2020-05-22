...
  View view = db.getView("YourViewSortedByLastModified");
  view.setAutoUpdate(false);
  Document tmpdoc;
  Document doc = view.getFirstDocument();
  while (doc != null) {
    // do with your doc what you want
    tmpdoc = view.getNextDocument(doc);
    doc.recycle();
    doc = tmpdoc;
  }