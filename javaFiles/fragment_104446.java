public void replaceRange(String str, int start, int end) {

    490         if (end < start) {
    491             throw new IllegalArgumentException  ("end before start");
    492         }
    493         Document doc = getDocument();
    494         if (doc != null) {
    495             try {
    496                 if (doc instanceof AbstractDocument) {
    497                     ((AbstractDocument)doc).replace(start, end - start, str,
    498                                                     null);
    499                 }
    500                 else {
    501                     doc.remove(start, end - start);
    502                     doc.insertString(start, str, null);
    503                 }
    504             } catch (BadLocationException e) {
    505                 throw new IllegalArgumentException  (e.getMessage());
    506             }
    507         }
    508     }