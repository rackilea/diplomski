import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestComponent extends JPanel {

    private String drawThis;

    public TestComponent() {
        this.drawThis = "Hello";
        JButton button = new JButton("Change");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                setDrawThis("World");
                repaint();
            }
        }); 
        this.add(button);
    }
    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawString(g, drawThis, 20, 20);
    }

    public void setDrawThis(String s) {
        this.drawThis = s;
    }

    public static void main(String s[]) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TestComponent tc = new TestComponent();

        f.add(tc);
        f.setSize(220, 220);
        f.setVisible(true);
    }
}