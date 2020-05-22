import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class TestFilechooser extends JFrame {

    private JPanel contentPane;
    MyFileChooser jc;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestFilechooser frame = new TestFilechooser();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TestFilechooser() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        jc = new MyFileChooser();
        JButton btnOpen = new JButton("open");
        contentPane.add(btnOpen, BorderLayout.NORTH);

        btnOpen.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int returnVal = jc.showOpenDialog(TestFilechooser.this);

            }
        });
        pack();
    }

}
class MyFileChooser extends JFileChooser{
    public MyFileChooser() {
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2" }));

        JPanel panel1 = (JPanel)this.getComponent(3);
        JPanel panel2 = (JPanel) panel1.getComponent(3);

        Component c1=panel2.getComponent(0);//optional used to add the buttons after combobox
        Component c2=panel2.getComponent(1);//optional used to add the buttons after combobox
        panel2.removeAll();

        panel2.add(comboBox);
        panel2.add(c1);//optional used to add the buttons after combobox
        panel2.add(c2);//optional used to add the buttons after combobox

   }
}