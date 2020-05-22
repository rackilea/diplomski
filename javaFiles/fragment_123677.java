tableViewerColumn.setLabelProvider(new StyledCellLabelProvider() {

    @Override
    public void update(ViewerCell cell) {
        cell.setText("Content");

        final int column = cell.getColumnIndex();
        final int row = Arrays.asList(tableViewer.getTable().getItems()).indexOf(cell.getItem());

        if (selection) {
            Display display = cell.getControl().getDisplay();
            cell.setBackground(display .getSystemColor(SWT.COLOR_LIST_SELECTION));
            cell.setForeground(display .getSystemColor(SWT.COLOR_LIST_SELECTION_TEXT));
        }

        super.update(cell);
    }
});