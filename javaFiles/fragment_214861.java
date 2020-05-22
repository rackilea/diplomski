import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame {

    public Test() {
        this.setTitle("Test");
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel jPanel = new JPanel() {
            @Override
            public void paintComponent(final Graphics g) {
                // call parent method
                super.paintComponent(g);

                // OR paint background yourself :
                // g.setColor(getBackground());
                // g.fillRect(0, 0, getWidth(), getHeight());


                // paint other things
                g.setColor(Color.GREEN);
                g.fillOval(100, 100, 100, 100);
                g.setColor(Color.BLACK);
                g.drawLine(0, 0, 100, 100);
            }
        };
        jPanel.setSize(500, 500);
        jPanel.setBackground(Color.RED);
        this.add(jPanel);
        this.setVisible(true);
        this.setSize(500, 500);
    }

    public static void main(final String[] args) {
        Test test = new Test();
    }
}