import java.awt.*;
import javax.swing.*;

public class ResizeIconInButton extends JFrame {
    private static final long serialVersionUID = 1L;

    public ResizeIconInButton() {
        JButton myButton = new JButton();
        myButton.setLayout(new BorderLayout());
        myButton.add(new CustomComponents0());
        add(myButton, BorderLayout.CENTER);
        setPreferredSize(getPreferredSize());
        setTitle("Resize Icon In Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                ResizeIconInButton main = new ResizeIconInButton();

            }
        };
        javax.swing.SwingUtilities.invokeLater(r);
    }
}

class CustomComponents0 extends JLabel {

    private static final long serialVersionUID = 1L;

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(200, 100);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }

    @Override
    public void paintComponent(Graphics g) {
        int margin = 10;
        Dimension dim = getSize();
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
    }
}