import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GridBagLayoutEg extends JPanel {
    private static final Insets INSETS = new Insets(5, 5, 5, 5);
    private static final int PREF_W = 800;
    private static final int PREF_H = 600;

    public GridBagLayoutEg() {
        JPanel innerPanel = new JPanel(new GridBagLayout());
        innerPanel.add(new JLabel("Sequence name: abcdc"), createGbc(0, 0));
        GridBagConstraints gbc = createGbc(1, 0);
        gbc.gridwidth = 3;
        innerPanel.add(new JLabel(), gbc);

        innerPanel.add(new JLabel("Block making alighment tool:", SwingConstants.LEFT), createGbc(0, 1));
        innerPanel.add(new JRadioButton("Mafft"), createGbc(1, 1));
        innerPanel.add(new JRadioButton("Muscle"), createGbc(2, 1));
        innerPanel.add(new JRadioButton("ClusteIO"), createGbc(3, 1));

        innerPanel.add(new JLabel("Select Codon Table:", SwingConstants.LEFT), createGbc(0, 2));
        innerPanel.add(new JRadioButton("Standard"), createGbc(1, 2));
        innerPanel.add(new JRadioButton("Custom"), createGbc(2, 2));
        innerPanel.add(new JLabel(), createGbc(3, 2));

        innerPanel.add(new JLabel("Strictness:", SwingConstants.LEFT), createGbc(0, 3));
        innerPanel.add(new JTextField(2), createGbc(1, 3));

        innerPanel.add(new JLabel("Degeneracy:", SwingConstants.LEFT), createGbc(0, 4));
        innerPanel.add(new JTextField(2), createGbc(1, 4));

        setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        add(innerPanel);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = INSETS;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("GridBagLayoutEg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GridBagLayoutEg());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}