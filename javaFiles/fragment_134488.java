import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Main extends JApplet {

    private JPanel content;

    public void init() {
        setLayout(new BorderLayout());

        content = new JPanel(new BorderLayout()) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 2000);
            }
        };
        add(content);

        JButton btn = new JButton("Show me the robot");
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.setEnabled(false);
                RobotPane botPane = new RobotPane();
                content.add(botPane);
                revalidate();
                repaint();
            }
        });
    }

    public class RobotPane extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 2000);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int A = 0;

//Hat
            g.setColor(Color.blue);
            int m[] = {A + 170, A + 120, A + 220};
            int hat[] = {0, 35, 35};
            int pts = 3;
            g.fillPolygon(m, hat, pts);
//head
            g.setColor(Color.gray);
            g.fillRoundRect(123, 35, 95, 95, 20, 20);
//Eye one
            g.setColor(Color.blue);
            g.fillOval(130, 50, 25, 25);
//Eye (inside) one
            g.setColor(Color.black);
            g.fillOval(137, 57, 10, 10);
//Eyelid right
            g.setColor(Color.cyan);
            g.fillArc(130, 50, 26, 15, -15, 220);
//Eye two 
            g.setColor(Color.blue);
            g.fillOval(185, 50, 25, 25);
//Eye (inside)two 
            g.setColor(Color.black);
            g.fillOval(192, 57, 10, 10);
//Eyelid left
            g.setColor(Color.cyan);
            g.fillArc(184, 50, 26, 15, -15, 220);
//Nose
            g.setColor(Color.green);
            g.fillRoundRect(165, 70, 10, 25, 20, 20);
//Mouth
            g.setColor(Color.red);
            g.fillArc(140, 90, 60, 40, 20, -220);
//Mouth (inside fill out)
            g.setColor(Color.white);
            g.fillArc(142, 99, 55, 26, 20, -220);
//Mouth (inside2 middle1)
            g.setColor(Color.red);
            g.drawArc(142, 97, 55, 20, 20, -220);
//Mouth (inside3 middle2)
            g.setColor(Color.red);
            g.drawArc(142, 98, 55, 20, 20, -220);
//Neck
            g.setColor(Color.gray);
            g.fillRect(155, 130, 30, 20);
//Body 
            g.setColor(Color.gray);
            g.fillRoundRect(100, 151, 145, 70, 20, 20);
//Body 2 
            g.setColor(Color.gray);
            g.fillRoundRect(120, 185, 100, 100, 20, 20);
//Chest 1 (left)
            g.setColor(Color.black);
            g.fillRoundRect(107, 157, 60, 50, 20, 20);
//Chest 2 (right)
            g.setColor(Color.black);
            g.fillRoundRect(178, 157, 60, 50, 20, 20);
//Abs 1 (left)
            g.setColor(Color.black);
            g.fillRoundRect(140, 209, 30, 22, 20, 20);
//Abs 2 (left)
            g.setColor(Color.black);
            g.fillRoundRect(140, 233, 30, 22, 20, 20);
//Abs 3 (left)
            g.setColor(Color.black);
            g.fillRoundRect(140, 257, 30, 22, 20, 20);
//Abs 1 (right)
            g.setColor(Color.black);
            g.fillRoundRect(174, 209, 30, 22, 20, 20);
//Abs 2 (right)
            g.setColor(Color.black);
            g.fillRoundRect(174, 233, 30, 22, 20, 20);
//Abs 3 (right)
            g.setColor(Color.black);
            g.fillRoundRect(174, 257, 30, 22, 20, 20);
//Arm 1 
            g.setColor(Color.gray);
            g.fillRoundRect(45, 151, 50, 130, 20, 20);
//Hand 1 
            g.setColor(Color.black);
            g.fillRoundRect(45, 250, 50, 30, 20, 20);
//Gun top hole
            g.setColor(Color.red);
            g.fillOval(55, 260, 30, 30);
//Gun 1 
            g.setColor(Color.blue);
            g.fillRoundRect(60, 270, 20, 60, 20, 20);
//Gun end 
            g.setColor(Color.black);
            g.fillRect(60, 320, 20, 10);
//Fire 
            g.setColor(Color.red);
            g.fillOval(63, 330, 14, 40);
//Arm 2
            g.setColor(Color.gray);
            g.fillRoundRect(250, 151, 50, 130, 20, 20);
//Hand 2 
            g.setColor(Color.black);
            g.fillRoundRect(250, 250, 50, 30, 20, 20);
//Saw top hole
            g.setColor(Color.red);
            g.fillOval(260, 260, 30, 30);
//Saw stick
            g.setColor(Color.black);
            g.fillRoundRect(270, 270, 10, 60, 20, 20);
//Saw teeth 1
            g.setColor(Color.gray);
            g.fillRect(256, 311, 38, 38);
//Saw teeth 2
            g.setColor(Color.red);
            int a[] = {A + 250, A + 275, A + 300, A + 275};
            int saw[] = {330, 305, 330, 355};
            int fourPoints = 4;
            g.fillPolygon(a, saw, fourPoints);
//Saw middle wheel 
            g.setColor(Color.black);
            g.fillOval(257, 312, 37, 37);
//Saw middle wheel end
            g.setColor(Color.gray);
            g.fillOval(267, 322, 16, 16);
//Pants 
            g.setColor(Color.black);
            g.fillRect(120, 284, 101, 50);
//Leg 1
            g.setColor(Color.gray);
            g.fillRoundRect(115, 335, 50, 150, 20, 20);
//Leg 2 
            g.setColor(Color.gray);
            g.fillRoundRect(181, 335, 50, 150, 20, 20);
//feet1
            g.setColor(Color.black);
            g.fillRoundRect(115, 460, 50, 30, 20, 20);
//feet2 
            g.setColor(Color.black);
            g.fillRoundRect(181, 460, 50, 30, 20, 20);
        }

    }
}