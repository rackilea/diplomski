JTable myTable = new JTable(10, 4) {
    private boolean inLayout;

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return hasExcessWidth();

    }


    @Override
    public void doLayout() {
        if (hasExcessWidth()) {
            // fool super
            autoResizeMode = AUTO_RESIZE_SUBSEQUENT_COLUMNS;
        }
        inLayout = true;
        super.doLayout();
        inLayout = false;
        autoResizeMode = AUTO_RESIZE_OFF;
    }


    protected boolean hasExcessWidth() {
        return getPreferredSize().width < getParent().getWidth();
    }

    @Override
    public void columnMarginChanged(ChangeEvent e) {
        if (isEditing()) {
            // JW: darn - cleanup to terminate editing ...
            removeEditor();
        }
        TableColumn resizingColumn = getTableHeader().getResizingColumn();
        // Need to do this here, before the parent's
        // layout manager calls getPreferredSize().
        if (resizingColumn != null && autoResizeMode == AUTO_RESIZE_OFF
                && !inLayout) {
            resizingColumn.setPreferredWidth(resizingColumn.getWidth());
        }
        resizeAndRepaint();
    }

};