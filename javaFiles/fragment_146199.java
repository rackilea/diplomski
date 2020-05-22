public class BillTableModel extends AbstractTableModel {
    protected String[] columnNames = new String[] { "Name", "Payment" };
    protected ArrayList<TestData> lstTestData;
    protected Class[] types = new Class[] { String.class, Double.class };
    ....
    ....
}