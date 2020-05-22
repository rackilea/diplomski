import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ainmationtester implements ActionListener {

    JFrame frame;
    JButton Button;
    int x = 30, y = 30;
    MyDrawPanels draw = new MyDrawPanels();
    public static void main(String[] args) {
        Ainmationtester test = new Ainmationtester();
        test.go();

    }

    public void go() {
        frame = new JFrame("Aniamtor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        Button = new JButton("CLick me to Animate");
        Button.addActionListener(this);
        frame.getContentPane().add(BorderLayout.NORTH, Button);
        frame.getContentPane().add(BorderLayout.CENTER, draw);
        frame.setVisible(true);
    }

    public class MyDrawPanels extends JPanel {
        private static final long serialVersionUID = 1L;
        public void paintComponent(Graphics g) {
            g.fillOval(x, y, 50, 50);
        }
    }

    public void actionPerformed(ActionEvent event) {
        x += 5;
        y += 5;
        frame.repaint();
    }
}