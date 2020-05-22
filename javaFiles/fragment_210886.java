import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @see https://stackoverflow.com/a/5663782/230513
 */
public class Main {

    private static class ChoicePanel {

        public static JPanel create(Draw draw) {
            JPanel p = new JPanel();
            final JComboBox colors = new JComboBox();
            for (Hue h : Hue.values()) {
                colors.addItem(h);
            }
            colors.addActionListener((ActionEvent e) -> {
                Hue h = (Hue) colors.getSelectedItem();
                draw.setBackground(h.getColor());
            });
            p.add(colors);
            return p;
        }
    }

    private static class Draw extends JPanel {

        public Draw() {
            this.setBackground(Hue.values()[0].getColor());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(320, 240);
        }
    }

    public enum Hue {

        Cyan(Color.cyan), Magenta(Color.magenta), Yellow(Color.yellow),
        Red(Color.red), Green(Color.green), Blue(Color.blue);

        private final Color color;

        private Hue(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }

    private void display() {
        JFrame f = new JFrame("Main");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Draw d = new Draw();
        f.add(d, BorderLayout.CENTER);
        f.add(ChoicePanel.create(d), BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Main().display();
        });
    }
}