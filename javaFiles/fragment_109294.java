class ClipboardMonitor {
    static WeakReference<Document> lastDocument;

    // return the last document where Ctrl+C was pressed, or null if
    // that document was closed and the garbage collector has already
    // reclaimed the memory
    static Document getLastDocument() {
        WeakReference<Document> weakDocument = lastDocument;
        return weakDocument != null ? weakDocument.get() : null;
    }

    static void copyCommand(Document document) {
        lastDocument = new WeakReference<Document>(document);
    }
}