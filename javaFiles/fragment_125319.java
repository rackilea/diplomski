JXTable table = new JXTable(new AncientSwingTeam());
// here the hideable property is configured manually, 
// in production code you'll probably have a custom ColumnFactory
// doing it based on some data state 
table.getColumnExt(0).setHideable(false);
ColumnControlButton columnControl = new ColumnControlButton(table) {

    @Override
    protected ColumnVisibilityAction createColumnVisibilityAction(
            TableColumn column) {
        if (column instanceof TableColumnExt
                && !((TableColumnExt) column).isHideable())
            return null;
        return super.createColumnVisibilityAction(column);
    }

};
table.setColumnControl(columnControl);
table.setColumnControlVisible(true);