import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {

    private static final int WIDE = 300;
    private static final int HIGH = 200;


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
    }

    public MyDrawPanel() {
        setBackground(Color.white);
        // Set a initial size for the program window
        this.setPreferredSize(new Dimension(WIDE, HIGH));
    }

     private void display() {
        // Some statements to let the JFrame appear in a good way
        JFrame f = new JFrame("MyDrawPanel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

     // Main method is called when the program is runned
     public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyDrawPanel().display();
            }
        });
    }
}