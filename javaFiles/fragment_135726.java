import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/* @see http://stackoverflow.com/a/19300995/230513 */
public class SerializationTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTable table = new JTable(new BlankTableModel());
                JTable copy = copyObject(table);
                copy.setValueAt("New data", 0, 0);

                JFrame f = new JFrame("SerializationTest");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLayout(new GridLayout(0, 1, 5, 5));
                f.add(table, BorderLayout.NORTH);
                f.add(copy, BorderLayout.SOUTH);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });

    }

    private static class BlankTableModel extends AbstractTableModel implements Serializable {

        private static final long serialVersionUID = 3141592653589793L;
        private String data = "Test data";

        public BlankTableModel() {
            this.addTableModelListener(new InnerTableModelListener());
        }

        @Override
        public void setValueAt(Object o, int row, int col) {
            data = o.toString();
            this.fireTableCellUpdated(row, col);
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public int getRowCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data;
        }

        private void save() {
            BlankTableModel model = copyObject(this);
            System.out.println(model.getValueAt(0, 0));
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return true;
        }

        private class InnerTableModelListener implements TableModelListener, Serializable {

            private static final long serialVersionUID = 2718281828459045L;

            @Override
            public void tableChanged(TableModelEvent e) {
                save();
            }
        }
    }

    private static <T extends Serializable> T copyObject(final T source) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(source);
            ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(baos.toByteArray()));
            final T copy = (T) ois.readObject();
            return copy;
        } catch (Exception e) {
            throw new AssertionError("Error copying: " + source);
        }
    }
}