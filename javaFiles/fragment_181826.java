import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

// based on @trashgod code
/** @see http://stackoverflow.com/questions/5759131 */

public class ListDialog {

    private static final int N = 12;
    private JDialog dlg = new JDialog();
    private DefaultListModel model = new DefaultListModel();
    private JList list = new JList(model);
    private JScrollPane sp = new JScrollPane(list);
    private int count;

    public ListDialog() {
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JPanel panel = new JPanel();
        panel.add(new JButton(new AbstractAction("Add") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                append();
                if (count <= N) {
                    list.setVisibleRowCount(count);
                    dlg.pack();
                }
            }
        }));
        panel.add(new JButton(new AbstractAction("Remove") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                int itemNo = list.getSelectedIndex();
                if (itemNo > -1) {
                    removeActionPerformed(e, itemNo);
                }
            }
        }));
        for (int i = 0; i < N - 2; i++) {
            this.append();
        }
        list.setVisibleRowCount(N - 2);
        dlg.add(sp, BorderLayout.CENTER);
        dlg.add(panel, BorderLayout.SOUTH);
        dlg.pack();
        dlg.setLocationRelativeTo(null);
        dlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dlg.setVisible(true);
    }

    private void removeActionPerformed(ActionEvent e, int itemNo) {
        System.out.println("made_list's model: " + list.getModel());
        System.out.println("Model from a fresh JList: " + new JList().getModel());
        model = (DefaultListModel) list.getModel();
        if (model.size() > 0) {
            if (itemNo > -1) {
                model.remove(itemNo);
            }
        }
    }

    private void append() {
        model.addElement("String " + String.valueOf(++count));
        list.ensureIndexIsVisible(count - 1);
    }

    public static void main(String[] a_args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ListDialog pd = new ListDialog();
            }
        });
    }
}