public abstract class Coordinator {

    /*
     * protected class members so subclasses can access these directly
     */

    protected ShipperAgent shipperAgent;
    protected DefaultTableModel tableModel;

    public Coordinator(ShipperAgent sa, DefaultTableModel tm) {
        shipperAgent = sa;
        tableModel = tm;
    }

    public abstract void notifyAndAddRow(Object[] rowData);

    public abstract void notifyAndDeleteRow(int rowIndex);
}