@Override
public IRenderer getNextRenderer() {
    CustomTableRenderer nextTable = new CustomTableRenderer((Table) modelElement);
    nextTable.rows.clear();
    nextTable.rowRange = null;
    return nextTable;
}