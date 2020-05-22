public class CheckBoxColumnEditingSupport extends EditingSupport {

    private TableViewer tableViewer;

    public CheckBoxColumnEditingSupport(TableViewer viewer) {
        super(viewer);
        this.tableViewer = viewer;
    }

    @Override
    protected CellEditor getCellEditor(Object o) {
        return new CheckboxCellEditor(null, SWT.CHECK);
    }

    @Override
    protected boolean canEdit(Object o) {
        return true;
    }

    @Override
    protected Object getValue(Object o) {
        ORMData ormData = (ORMData) o;
        return ormData.isOrmIndicator();
    }

    @Override
    protected void setValue(Object element, Object value) {
        ORMData ormData = (ORMData) element;
        ormData.setOrmIndicator((Boolean) value);
        tableViewer.refresh();
    }
}