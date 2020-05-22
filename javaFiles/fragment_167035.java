protected static int modelOffset2WidgetOffset(ISourceViewer viewer, int modelOffset) {
    if (viewer instanceof ITextViewerExtension5) {
        ITextViewerExtension5 extension = (ITextViewerExtension5) viewer;
        return extension.modelOffset2WidgetOffset(modelOffset);
    }
    return modelOffset - viewer.getVisibleRegion().getOffset();
}