import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Stack extends JFrame implements MouseMotionListener{
    int x;
    int y;
    JPanel p = new JPanel();
    JPanel detectPanel = new JPanel();
    JTextField t = new JTextField(10);
    JLabel l = new JLabel("Position's inside of bordered panel: ");
    public Stack(){
        setLayout(new BorderLayout());
        t.setEditable(false);
        p.add(l);
        p.add(t);
        detectPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(p,BorderLayout.NORTH);
        add(detectPanel,BorderLayout.CENTER);
        detectPanel.addMouseMotionListener(this);

    }

    public static void main(String[] a){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Stack s = new Stack();
                s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                s.setLocationByPlatform(true);
                s.setPreferredSize(new Dimension(640,480));
                s.pack();
                s.setVisible(true);
            }
        });
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        x= e.getX();
        y= e.getY();
        t.setText(x+", "+y);
    }
}