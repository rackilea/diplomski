import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLayout {

    public static void main(String[] args) {
        new TestLayout();
    }

    public TestLayout() {
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

        private JTextField numberOfPizzas;
        private JCheckBox pepperoni;
        private JCheckBox sausage;
        private JCheckBox peppers;
        private JCheckBox onions;
        private JCheckBox mushrooms;
        private JCheckBox extracheese;

        private JLabel lblSubTotal;
        private JLabel lblTax;
        private JLabel lblTotal;

        public TestPane() {

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JPanel header = new JPanel();
            JPanel extras = new JPanel(new GridBagLayout());
            JPanel totals = new JPanel(new GridBagLayout());

            add(header, gbc);
            gbc.gridy++;
            add(extras, gbc);
            gbc.gridy++;
            add(totals, gbc);

            numberOfPizzas = new JTextField(5);
            header.add(new JLabel("Number of pizzas"));
            header.add(numberOfPizzas);

            gbc = new GridBagConstraints();

            pepperoni = new JCheckBox("Pepperoni");
            sausage = new JCheckBox("Sausage");
            peppers = new JCheckBox("Peppers");
            onions = new JCheckBox("Onions");
            mushrooms = new JCheckBox("mushrooms");
            extracheese = new JCheckBox("Extra Cheeses");

            JCheckBox left[] = new JCheckBox[] {pepperoni, peppers, mushrooms};
            JCheckBox right[] = new JCheckBox[] {sausage, onions, extracheese};

            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(left, extras, 0, 1, gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            add(right, extras, 0, 1, gbc);

            gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.insets = new Insets(2, 12, 2, 12);

            totals.add(new JLabel("Subtotal:"), gbc);
            gbc.gridy++;
            totals.add(new JLabel("Tax:"), gbc);
            gbc.gridy++;
            totals.add(new JLabel("Total:"), gbc);

            gbc.weightx = 0;
            gbc.gridx = 1;
            gbc.gridy = 0;

            lblSubTotal = new JLabel("8.0");
            lblTax = new JLabel("0.78");
            lblTotal = new JLabel("8.78");

            totals.add(lblSubTotal, gbc);
            gbc.gridy++;
            totals.add(lblTax, gbc);
            gbc.gridy++;
            totals.add(lblTotal, gbc);

        }

        protected void add(JComponent[] comps, JComponent parent, int deltaX, int deltaY, GridBagConstraints gbc) {

            for (JComponent comp : comps) {
                parent.add(comp, gbc);
                gbc.gridy += deltaY;
                gbc.gridx += deltaX;
            }

        }
    }

}