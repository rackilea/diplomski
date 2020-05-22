public static DocumentViewer getDocumentViewer() {
    if (Build.VERSION.SDK_INT >= 23) {
        return new DocumentViewer23();
    } else {
        return new DocumentViewerPre23();
    }
}