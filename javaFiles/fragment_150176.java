import java.awt.Toolkit;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main {
    public static boolean checkValid(final String text) {
        return text != null && !text.trim().isEmpty(); //Your checks here...
    }

    public static class MyCellEditor extends DefaultCellEditor {
        public MyCellEditor() {
            super(new JTextField());
        }

        @Override
        public boolean stopCellEditing() {
            final JTextField field = (JTextField) getComponent();
            if (checkValid(field.getText())) {
                //field.setBackground(Color.WHITE);
                return super.stopCellEditing(); //Fires 'editing stopped' event and returns true.
            }
            Toolkit.getDefaultToolkit().beep();
            //field.setBackground(Color.ORANGE.darker());
            JOptionPane.showMessageDialog(field, "You must enter a non-empty value!", "Oups!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void main(final String[] args) {
        final JTable table = new JTable(new DefaultTableModel(10, 10));
        table.setDefaultEditor(Object.class, new MyCellEditor());

        final JFrame frame = new JFrame("JTable DefaultEditor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(table);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}