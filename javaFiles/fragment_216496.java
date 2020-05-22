import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Back extends JFrame{

/**
 * 
 */
private static final long serialVersionUID = 1L;
private JButton r;
public Back(){
    super("title");
    setLayout(null);
    r=new JButton("ROLL");
    r.setBounds(20, 20, 70, 30);
    add(r);

    Thehandler hand=new Thehandler(this);//konstruktori i handler merr nje instance te Background
    r.addActionListener(hand);
}

private class Thehandler implements ActionListener{
    private JFrame frame;
    public Thehandler(JFrame frame) {
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent event) {
        Random ra = new Random();
        int r = ra.nextInt(255);
        int g = ra.nextInt(255);
        int b = ra.nextInt(255);
        Color c = new Color(r, g, b);

        frame.getContentPane().setBackground(c);

    }
}

public static void main(String[] args) {
     Back  d = new Back() ;

     d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     d.getContentPane().setBackground(Color.GREEN);
     d.setSize(700,500);

     d.setVisible(true);    
}
}