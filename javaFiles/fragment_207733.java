import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AddJCheckBoxToJScrollPane {

    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame();
    private JButton jButton1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public AddJCheckBoxToJScrollPane() {
        jPanel1 = new JPanel();
        jPanel1.setLayout(new GridLayout(0, 2, 10, 10));
        jScrollPane1 = new JScrollPane(jPanel1);
        jButton1 = new JButton("Add Checkbox");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCheckBox cb = new JCheckBox("New CheckBox");
                jPanel1.add(cb);
                jPanel1.revalidate();
                jPanel1.repaint();
            }
        });
        frame.add(jScrollPane1);
        frame.add(jButton1, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AddJCheckBoxToJScrollPane();
            }
        });
    }
}