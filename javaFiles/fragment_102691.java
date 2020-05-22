import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @see http://stackoverflow.com/a/18040085/230513
 */
public class Test {

    private abstract class Player {

        private String name;

        public Player(String name) {
            this.name = name;
        }

        public void play() {
            choose();
        }

        abstract public void choose();

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private class Human extends Player {

        public Human() {
            super(JOptionPane.showInputDialog(null, "Name"));
        }

        @Override
        public void choose() {
            System.out.println(getName() + " choosing.");
            // check user selection
        }

        @Override
        public void setName(String name) {
            super.setName(name);
        }
    }

    private class Computer extends Player {

        public Computer() {
            super("Boris");
        }

        @Override
        public void choose() {
            System.out.println(getName() + " choosing.");
            // select majority
        }
    }

    private JPanel createPlayerPanel(final Player player) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(player.getName(), JLabel.CENTER));
        panel.add(new JButton(new AbstractAction("Play") {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.play();
            }
        }));
        return panel;
    }

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(0, 1));
        f.add(createPlayerPanel(new Human()));
        f.add(createPlayerPanel(new Computer()));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}