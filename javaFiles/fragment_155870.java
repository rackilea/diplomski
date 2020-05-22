import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CodeTester extends JFrame implements KeyListener
{
    JPanel panel = new JPanel();

    public static void main(String[] args)
    {
        JFrame frame = new CodeTester();
        frame.setSize(400, 400);
        frame.setVisible(true);    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public CodeTester()
    {
        addKeyListener(this);
        getContentPane().add(panel);        
    }

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}

    public void keyReleased(KeyEvent e) 
    {
        int choice = JOptionPane.showInternalConfirmDialog(panel, 
                    "Would you like to play the movie? " 
                       ,"Message", JOptionPane.WARNING_MESSAGE
                    , JOptionPane.OK_CANCEL_OPTION);                

    }
}