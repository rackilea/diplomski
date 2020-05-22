import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableSelectionToLabel {
    private static JTable t = new JTable(new String[][]{{"1,1", "1,2"}, {"2,1", "2,2"}}, 
                            new String[]{"1", "2"});
    private static JLabel l = new JLabel("Your selction will appear here");
    private static JFrame f = new JFrame("Table selection listener Ex.");
    private static ListSelectionListener myListener = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int col = t.getColumnModel().getSelectionModel().getLeadSelectionIndex();
            int row = t.getSelectionModel().getLeadSelectionIndex();
            try {
                l.setText(t.getModel().getValueAt(row, col).toString());
            } catch (IndexOutOfBoundsException ignore) {

            }
        }
    };

    public static void main(String[] args) {
        t.getSelectionModel().addListSelectionListener(myListener);
        t.getColumnModel().getSelectionModel().addListSelectionListener(myListener);
        f.getContentPane().add(t, BorderLayout.NORTH);
        f.getContentPane().add(l, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}