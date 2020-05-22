package testframe2;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class TestFrame2 {

public static void main(String[] args) {
    new TestFrame2();
}

public TestFrame2() {


    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            JFrame frame = new JFrame("Testing");

            frame.setUndecorated(true);
            frame.setAlwaysOnTop(true);               
            frame.setBackground(new Color(0, 0, 0, 0));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                               
            frame.getContentPane().add(new TestPane());                                              
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }
    });

}

public class TestPane extends JPanel {

    private JLabel label = new JLabel("hello world");

    public TestPane() {
        super();
        this.add(label);
    }
}
}