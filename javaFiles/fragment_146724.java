import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Test {
    private static JFrame testWindow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI(); 
            }
        });
    }

    private static void createUI() {
        testWindow = new JFrame("Test");
        testWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testWindow.add(new MyPanel());
        testWindow.pack();
        testWindow.setVisible(true);

    }
}

class MyPanel extends JPanel {

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(500,500);
    }

    public void paintComponent(Graphics g) {     
        super.paintComponent(g);       
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.RED);
        g2.fillRect(10,10,100,100);

        g2.dispose();
    }  
}