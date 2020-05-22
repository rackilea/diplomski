import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DiceRollGUI {

    public static JLabel label;
    public static JFrame frame;
    public static JPanel panel;
    private static JButton button;
    private static JButton buttonRollDie;
    private static JLabel diceRoll;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dice Roll GUI");
        panel = new JPanel();
        JPanel contentPanel = new JPanel(new GridLayout(0, 2, 5, 10));
        button = new JButton("Roll");

        // !! Add this !! //
        diceRoll = new JLabel();
        contentPanel.add(diceRoll);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.setActionCommand("Roll");
        button.addActionListener(new RollButton(diceRoll));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(750, 500));
        frame.setContentPane(panel);
        frame.pack();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(button);
    }

    private static class RollButton implements ActionListener {

        // !! Change This !! //
        private JLabel diceRoll;

        // !! Change This !! //
        public RollButton(JLabel diceRoll) {
            // !! Change This !! //
            this.diceRoll = diceRoll;
        }

        public void actionPerformed(ActionEvent event) {
            int roll = (int) (Math.round((Math.random() * 5) + 1));
            ImageIcon dice = null;

            if (roll == 1) {
                dice = new ImageIcon("DiceRollGUI Pictures/die_face_1.png");
            } else if (roll == 2) {
                dice = new ImageIcon("DiceRollGUI Pictures/die_face_2.png");
            } else if (roll == 3) {
                dice = new ImageIcon("DiceRollGUI Pictures/die_face_3.png");
            } else if (roll == 4) {
                dice = new ImageIcon("DiceRollGUI Pictures/die_face_4.jpeg");
            } else if (roll == 5) {
                dice = new ImageIcon("DiceRollGUI Pictures/die_face_5.png");
            } else if (roll == 6) {
                dice = new ImageIcon("DiceRollGUI Pictures/die_face_6.png");
            }
            // !! Change This !! //
            diceRoll.setIcon(dice);
        }
    }
}