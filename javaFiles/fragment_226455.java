CellNavigationStrategy navigationStrategy = new CellNavigationStrategy() {
        @Override
        public boolean shouldCancelEvent(ColumnViewer viewer, Event event) {
            return true;
        }
        @Override
        public boolean isNavigationEvent(ColumnViewer viewer, Event event) {
            return false;
        }
    };
    TableViewerFocusCellManager focusCellManager = new TableViewerFocusCellManager(tableViewer, new FocusCellOwnerDrawHighlighter(tableViewer), navigationStrategy);