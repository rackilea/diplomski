import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @see https://stackoverflow.com/a/14422016/230513 */
public class Scores {

    private final JLabel[] nameLabel = new JLabel[]{
        new JLabel("Team 1", JLabel.CENTER),
        new JLabel("Team 2", JLabel.CENTER)};

    private void display() {
        JFrame f = new JFrame("Scores");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel teamPanel = new JPanel(new GridLayout(1, 0));
        teamPanel.add(nameLabel[0]);
        teamPanel.add(nameLabel[1]);
        f.add(teamPanel, BorderLayout.NORTH);
        f.add(new JPanel() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        }, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Scores().display();
            }
        });
    }
}