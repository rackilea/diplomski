import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Frames extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Frames();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Frames() {
        setSize(new Dimension(100, 100));
        setTitle("MAIN MENU");
        getContentPane().setBackground(Color.YELLOW);
        setVisible(true);
    }

}