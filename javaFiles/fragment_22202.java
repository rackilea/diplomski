import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionListener;
import java.util.Timer;

import javax.swing.JPanel;


public class EyesPanel extends JPanel implements ActionListener,MouseMotionListener{
    private JPanel panel;
    private int y;
    private int dy;
    private Timer t;


    public EyesPanel() {
        dy = 5;
        y = 145;

        // mouse detector
        this.addMouseMotionListener(this);


        // Timer 

    }

    // images
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawOval(130, 100, 120, 120);
        g.drawOval(250, 100, 120, 120);
        g.fillOval(175, y, 30, 30);   // x: 175  y: 145
        g.fillOval(295, y, 30, 30);   // x: 295  y: 145
    }



    // move up

    // ➜ not complete, trying, but no clue




@Override
public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub

}

    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println(arg0.getY());
        if(arg0.getY() > 101 && arg0.getY() < 187)
        y = arg0.getY();
        repaint();

    }


}