import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestComboBox {

    public static void main(String[] args) {
        new TestComboBox();
    }

    public TestComboBox() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JComboBox comboBox;
        private JButton update;

        public TestPane() {
            setLayout(new GridBagLayout());
            update = new JButton("Update");
            comboBox = new JComboBox();

            update.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateCombo();
                }
            });

            updateCombo();

            add(comboBox);
            add(update);
        }

        protected void updateCombo() {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            Random rnd = new Random();
            for (int index = 0; index < 10 + rnd.nextInt(90); index++) {
                model.addElement(rnd.nextInt(1000));
            }
            comboBox.setModel(model);
        }

    }

}