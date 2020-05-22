import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Test implements MouseListener {
    private JLabel imageLabel1, imageLabel2;

    public Test() {
        JFrame frame = new JFrame("Test");
        frame.setLayout(new BorderLayout());

        JLabel introLabel = new JLabel("Click an image");
        introLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(introLabel,BorderLayout.NORTH);

        imageLabel1 = new JLabel(new ImageIcon("image1.png"));
        frame.add(imageLabel1,BorderLayout.WEST);
        imageLabel1.addMouseListener(this);

        imageLabel2 = new JLabel(new ImageIcon("image2.png"));
        frame.add(imageLabel2,BorderLayout.EAST);
        imageLabel2.addMouseListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent ev) {
        if (ev.getSource() == imageLabel1)
            System.out.println("Image 1 clicked");
        if (ev.getSource() == imageLabel2)
            System.out.println("Image 2 clicked");
    }

    @Override public void mouseEntered(MouseEvent ev) {}
    @Override public void mouseExited(MouseEvent ev) {}
    @Override public void mousePressed(MouseEvent ev) {}
    @Override public void mouseReleased(MouseEvent ev) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test();
            }
        });
    }
}