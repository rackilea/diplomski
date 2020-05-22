import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.swing.EventTableModel;
import ca.odell.glazedlists.swing.TableComparatorChooser;
import java.util.Comparator;
import java.util.List;
import javax.swing.ComboBoxEditor;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.jdesktop.swingx.JXTable;

public class Tester {

    private static class MyObject implements Comparable<MyObject> {

        private final int number;
        private final String value;

        public MyObject(int number, String value) {
            this.number = number;
            this.value = value;
        }

        public int getNumber() {
            return number;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int compareTo(MyObject t) {
            return value.compareTo(t.getValue());
        }
    }

    private static class MyTableFormat implements TableFormat<MyObject> {

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int i) {
            switch (i) {
                case 0:
                    return "FormattedNumber";
                case 1:
                    return "String";
                default:
                    throw new IllegalStateException();
            }
        }

        @Override
        public Object getColumnValue(MyObject e, int i) {
            switch (i) {
                case 0:
                    return getNumberString(e.getNumber());
                case 1:
                    return e.getValue();
                default:
                    throw new IllegalStateException();
            }
        }

        private Object getNumberString(int number) {
            switch (number) {
                case 1:
                    return "One";
                case 2:
                    return "Two";
                case 3:
                    return "Three";
                default:
                    throw new IllegalStateException();
            }
        }
    }

    private static class MyComparator implements Comparator<MyObject> {

        @Override
        public int compare(MyObject t, MyObject t1) {
            return Integer.valueOf(t.getNumber()).compareTo(Integer.valueOf(t1.getNumber()));
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventList<MyObject> list = new BasicEventList<MyObject>();
        list.add(new MyObject(1, "A"));
        list.add(new MyObject(2, "B"));
        list.add(new MyObject(3, "C"));

        SortedList<MyObject> sortedList = new SortedList<MyObject>(list);

        EventTableModel<MyObject> tableModel = new EventTableModel<MyObject>(sortedList, new MyTableFormat());
        JXTable jxtable = new JXTable(tableModel);

        /** 
         * START
         * - Deactivate JXTables build-in sorting
         * - Install GlazedLists sorting
         * - Set the comparator for the "string number" column
         */

        // deactivate sorting of JXTable
        jxtable.setSortable(false);
        jxtable.setAutoCreateRowSorter(false);
        jxtable.setRowSorter(null);

        // enable GlazedLists sorting
        TableComparatorChooser<MyObject> tcc = TableComparatorChooser.install(jxtable, sortedList, TableComparatorChooser.SINGLE_COLUMN);

        // set the comparator for your "string number" column
        List<Comparator> comparators = tcc.getComparatorsForColumn(0);
        comparators.clear();
        comparators.add(new MyComparator());

        /**
         * END
         */

        JFrame f = new JFrame("Tester");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new JScrollPane(jxtable));
        f.pack();
        f.setVisible(true);
    }
}