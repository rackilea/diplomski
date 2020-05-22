import javax.swing.UIManager.*;
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class TestJavaProblem extends JFrame {

    private static final long serialVersionUID = 1L;
    private JComboBox jComboBox1;
    private boolean boloComboBox = false;

    public TestJavaProblem() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        jComboBox1 = new JComboBox();
        jComboBox1.setModel(new DefaultComboBoxModel(new String[]{"1", "2"}));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(final java.awt.event.ItemEvent evt) {
                if (jComboBox1.isPopupVisible()) {
                    jComboBox1.setPopupVisible(false);
                    SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            fireTask(evt);
                        }
                    });
                }
            }
        });
        jComboBox1.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                System.out.println(e.getSource());
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                System.out.println(e.getSource());
            }

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                System.out.println(e.getSource());
            }
        });
        add(jComboBox1);
        pack();
    }

    private void fireTask(java.awt.event.ItemEvent evt) {
        if (evt.getStateChange() == 2) {
            int i = JOptionPane.showConfirmDialog(jComboBox1, 
                "Message Text", "Title", JOptionPane.OK_CANCEL_OPTION);
            System.out.println("Result:" + i);
        }
    }

    public static void main(String args[]) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestJavaProblem().setVisible(true);
            }
        });
    }
}