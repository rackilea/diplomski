import java.awt.*;
import javax.swing.*;

public class Test {
    public static void main(String []args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();

                JPanel panel1 = new JPanel();
                JPanel panel2 = new JPanel();

                panel1.setBorder(BorderFactory.createTitledBorder("Panel 1"));
                panel2.setBorder(BorderFactory.createTitledBorder("Panel 2"));

                frame.add(panel1, BorderLayout.NORTH);
                frame.add(panel2, BorderLayout.CENTER);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(200, 200));
                frame.setVisible(true);
            }
        });
    }
}