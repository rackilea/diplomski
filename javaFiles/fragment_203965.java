import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
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

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            JPanel stockTableProxy = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(200, 150);
                }
            };
            stockTableProxy.setBackground(Color.RED);

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.LINE_START;
            add(stockTableProxy, gbc);


            JPanel fieldsPanel = new JPanel(new GridBagLayout());
            fieldsPanel.setBackground(Color.BLUE);

            // TEST COMPONENTS
            JLabel lblItem = new JLabel("Item: ");
            JLabel lblPrice = new JLabel("Price: ");
            JLabel lblQuantity = new JLabel("Quantity: ");

            JTextField itemField = new JTextField(15);
            JTextField pricePoundsField = new JTextField(3);
            JTextField pricePenceField = new JTextField(2);
            JTextField quantityField = new JTextField(3);

            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.LINE_END;
            fieldsPanel.add(lblItem, gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            fieldsPanel.add(lblPrice, gbc);

            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.gridx = 2;
            gbc.gridy = 0;
            fieldsPanel.add(itemField, gbc);

            gbc.gridx = 2;
            gbc.gridy = 1;
            fieldsPanel.add(pricePoundsField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 20;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weighty = 1;
            fieldsPanel.add(new JLabel(), gbc);

            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.fill = GridBagConstraints.VERTICAL;
            add(fieldsPanel, gbc);
        }

    }

}