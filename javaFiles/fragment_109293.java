class ClipboardMonitor {
    static Document lastDocument;

    // return the last document where Ctrl+C was pressed
    static Document getLastDocument() {
        return lastDocument;
    }

    static void copyCommand(Document document) {
        lastDocument = document;
    }
}