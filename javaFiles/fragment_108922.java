import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GridBagLayoutTest100 {

    public static void main(String[] args) {
        new GridBagLayoutTest100();
    }

    public GridBagLayoutTest100() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            JLabel lblProtocolo = new JLabel("Protocolo:");
            JLabel lblDataEntrada = new JLabel("Data Entrada:");
            JTextField tfProtocolo = new JTextField(10);
            JTextField tfDataEntrada = new JTextField(10);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.anchor = GridBagConstraints.WEST;

            add(lblProtocolo, gbc);
            gbc.gridx++;
            gbc.weightx = 1;
            add(tfProtocolo, gbc);

            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx++;
            add(lblDataEntrada, gbc);
            gbc.gridx++;
            gbc.weightx = 0;
            add(tfDataEntrada, gbc);            
        }
    }
}