import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    public Test() {
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }

    private void initComponents() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {//the frame should now return a width and height of 300
                return new Dimension(300, 300);
            }
        };

        JButton button = new JButton("Get JFrame real width and height");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Dimension frameSize = frame.getSize();
                Insets insets = frame.getInsets();

                System.out.println("Frame size via getSize(): " + frameSize);
                System.out.println("Insets: " + insets);

                double width = frameSize.getWidth();
                double height = frameSize.getHeight();

                //calculate real width/height
                double realWidth = width - (insets.left + insets.right);
                double realHeight = height - (insets.top + insets.bottom);

                System.out.println("Width: " + realWidth + " Height: " + realHeight);
            }
        });

        panel.add(button);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);

    }
}