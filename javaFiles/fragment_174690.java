package mouseeventshandling;
import java.awt.*;
import java.awt.event.*;
public class MouseEventsHandling extends Frame implements MouseListener,   MouseMotionListener {
    TextField tf;
    public MouseEventsHandling(String title){
        super(title);
        tf=new TextField(60);
        addMouseListener(this);
    }
    public void launchFrame(){
        add(tf, BorderLayout.SOUTH);
        setSize(300,300);
        setVisible(true);
    }
    public void mouseClicked(MouseEvent me){
        String msg = "Mouse Clicked";
        tf.setText(msg);
    }
    public void mouseEntered(MouseEvent me){
        String msg = "Mouse Entered Component";
        tf.setText(msg);
    }
    public void mouseExited(MouseEvent me){
        String msg = "Mouse Exited Component";
        tf.setText(msg);
    }
    public void mousePressed(MouseEvent me){
        String msg = "Mouse pressed";
        tf.setText(msg);
    }
    public void mouseReleased(MouseEvent me){
        String msg = "Mouse released";
        tf.setText(msg);
    }
    public void mouseDragged(MouseEvent me){
        String msg = "Mouse dragged at " + me.getX() + "," + me.getY();
        tf.setText(msg);
    }
    @Override
    public void mouseMoved(MouseEvent arg0) {

    }
}