import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * <applet code="AppletDemo" width = 200 height = 100></applet>
 */

public class AppletDemo extends Applet {
    String msg = "Text Animating from right to left...";
    int state;
    boolean stopFlag;
    int msgX = 200;
    String s;
    boolean diff;
    JPanel panel;

    public void init() {
        setBackground(Color.cyan);
        setForeground(Color.black);
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponents(g);
                g.drawString(msg, msgX, 20);
                showStatus(diff + "Text at " + msgX + ",20");
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 40);
            }
        };
        add(panel);

        int delay = 10; // milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (msgX >= -150)
                    msgX--;
                else
                    msgX = 200;
                repaint();
            }
        };
        Timer timer = new Timer(delay, taskPerformer);
        timer.setRepeats(true);
        timer.start();
    }

}