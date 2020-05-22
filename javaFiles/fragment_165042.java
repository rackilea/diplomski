TableViewer viewer = ...

TableViewerFocusCellManager focusCellManager = new TableViewerFocusCellManager(viewer, new FocusCellOwnerDrawHighlighter(viewer));

ColumnViewerEditorActivationStrategy activationSupport = new ColumnViewerEditorActivationStrategy(viewer) {
    protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
        // Enable editor only with mouse double click
        if (event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION) {
            EventObject source = event.sourceEvent;
            if (source instanceof MouseEvent && ((MouseEvent)source).button == 3)
                return false;

            return true;
        }

        return false;
    }
};

TableViewerEditor.create(viewer, focusCellManager, activationSupport, ColumnViewerEditor.TABBING_HORIZONTAL | 
    ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR | 
    ColumnViewerEditor.TABBING_VERTICAL |
    ColumnViewerEditor.KEYBOARD_ACTIVATION);