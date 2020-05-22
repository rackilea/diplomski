import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class HelloWorldSwing {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TestView.getView();
            }
        });
    }    
}

class TestView {

    private static TestView view = new TestView();

    public static TestView getView() {
        return view;
    }

    private TestView() {
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setLayout(new GridLayout(3,4));
        int buttonSize = 40;

        for (int i=0; i<12; i++) {
            frame.getContentPane().add(new MyButton(buttonSize));
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void initialize() {
    }
}

class MyButton extends JButton {

    int size;

    public MyButton(int size) {
        this.size = size;
        setPreferredSize(new Dimension(size, size));
        this.addActionListener(new ButtonHandler());
        setOpaque(true);
        setYellow();
    }

    public Image getImage(int sz, Color color) {
        BufferedImage bi = new BufferedImage(sz,sz,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setColor(color);
        g.fillRect(0, 0, sz, sz);

        g.dispose();
        return bi; 
    }

    public void setYellow() {
        Image img = getImage(64, Color.YELLOW).getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH); 
        setIcon(new ImageIcon(img));
        Image rollover = getImage(64, Color.ORANGE).getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH);
        setRolloverIcon(new ImageIcon(rollover));
        setBorderPainted(false);
        setContentAreaFilled(false); 
    }
}

class ButtonHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MyButton mb = (MyButton) e.getSource();
        mb.setYellow();
    }
}