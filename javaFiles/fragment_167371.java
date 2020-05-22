import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SlidingControl {
    Frame frame = new Frame("Sliding Control");
    JPanel left = new JPanel(), right = new JPanel(), middle = new JPanel();

    public static void main(String[] args) {
        SlidingControl application = new SlidingControl();
        application.movePanels();
    }

    public SlidingControl() {
        frame.setSize(600, 200);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setResizable(false);
        frame.setVisible(true);
        initializePanels();
    }

    private void initializePanels(){
        frame.setLayout(null);
        frame.add(left);
        frame.add(middle);
        frame.add(right);
        left.setBackground(new Color(1f, 0f, 0f));
        middle.setBackground(new Color(0f, 1f, 0f));
        right.setBackground(new Color(0f, 0f, 1f));
        left.setBounds(10, 10, 50, 100);
        middle.setBounds(400, 50, 50, 200);
        right.setBounds(500, 50, 50, 200);
    }

    public void movePanels(){
        while(true){
            left.setBounds(left.getBounds().x - 5, left.getBounds().y, left.getBounds().width, left.getBounds().height);
            middle.setBounds(middle.getBounds().x - 5, middle.getBounds().y, middle.getBounds().width, middle.getBounds().height);
            right.setBounds(right.getBounds().x - 5, right.getBounds().y, right.getBounds().width, right.getBounds().height);
            try{
                Thread.sleep(600);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}