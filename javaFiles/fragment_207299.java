import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class APanel extends JPanel{

    APanel(){
        setPreferredSize(new Dimension(600,400));
        setBackground(Color.YELLOW); //panel color to make it distinct

        //add button
        JButton btn = new JButton();
        btn.setPreferredSize(new Dimension(100,30)); //use layout manager to place it where you want
        btn.setContentAreaFilled(false);//make btn transparent
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));//change button cursor
        //optionally : remove border by btn.setBorder(null);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button pressed !");
            }
        });
        add(btn);   
    }

    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new APanel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}