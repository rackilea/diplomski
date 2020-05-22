import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class TestGridBagLayout100 {

    public static void main(String[] args) {
        new TestGridBagLayout100();
    }

    public TestGridBagLayout100() {
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
            setLayout(new GridBagLayout());
//            setBackground(Color.BLACK);

            GridBagConstraints leftGrid = new GridBagConstraints();
            JLabel label;

            label = new JLabel("Player's Goods:");
            leftGrid.fill = GridBagConstraints.NONE;
            leftGrid.anchor = GridBagConstraints.NORTHWEST;
//            leftGrid.insets = new Insets(10, 10, 10, 10);
            leftGrid.weighty = 0.5;
            leftGrid.gridx = 0;
            leftGrid.gridy = 0;
            leftGrid.gridwidth = GridBagConstraints.REMAINDER;
            add(label, leftGrid);

            //??
            leftGrid.gridwidth = 1;
            label = new JLabel("");
            leftGrid.weighty = 0;
            leftGrid.weightx = 0;
            leftGrid.gridx = 0;
            leftGrid.gridy = 1;
            add(label, leftGrid);

            label = new JLabel("Nails:");
            leftGrid.gridy = 0;
            leftGrid.ipady = 50;
            leftGrid.gridx = 0;
            leftGrid.gridy = 2;
            add(label, leftGrid);

            label = new JLabel("Wheat:");
            leftGrid.gridx = 0;
            leftGrid.gridy = 3;
            add(label, leftGrid);

            label = new JLabel("Armor:");
            leftGrid.gridx = 0;
            leftGrid.gridy = 4;
            add(label, leftGrid);

            label = new JLabel("Gold:");
            leftGrid.gridx = 0;
            leftGrid.gridy = 5;
            add(label, leftGrid);

            label = new JLabel("Weapons:");
            leftGrid.gridx = 0;
            leftGrid.gridy = 6;
            add(label, leftGrid);

            label = new JLabel("Spice:");
            leftGrid.gridx = 0;
            leftGrid.gridy = 7;
            add(label, leftGrid);

            label = new JLabel("0 lbs.");
            label.setBorder(new LineBorder(Color.RED));
            label.setHorizontalAlignment(JLabel.LEFT);
            leftGrid.fill = GridBagConstraints.HORIZONTAL;
            leftGrid.anchor = GridBagConstraints.WEST;
            leftGrid.ipady = 0;
//            leftGrid.ipadx = 50;
            leftGrid.weightx = 1;
            leftGrid.gridx = 1;
            leftGrid.gridy = 2;
            add(label, leftGrid);

            label = new JLabel("0 lbs.");
            leftGrid.gridx = 1;
            leftGrid.gridy = 3;
            add(label, leftGrid);

            label = new JLabel("0 lbs.");
            leftGrid.gridx = 1;
            leftGrid.gridy = 4;
            add(label, leftGrid);

            label = new JLabel("0 lbs.");
            leftGrid.gridx = 1;
            leftGrid.gridy = 5;
            add(label, leftGrid);

            label = new JLabel("9999 lbs.");
            leftGrid.gridx = 1;
            leftGrid.gridy = 6;
            add(label, leftGrid);

            label = new JLabel("0 lbs.");
            leftGrid.gridx = 1;
            leftGrid.gridy = 7;
            add(label, leftGrid);

            label = new JLabel("666 Coins");
//            leftGrid.ipady = 50;
            leftGrid.weighty = 1;
            leftGrid.gridx = 1;
            leftGrid.gridy = 8;
            add(label, leftGrid);
        }
    }

}