import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Main extends JFrame {

    public Main() {
        setTitle("Custom Component Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display() {
        add(new CustomComponent());
        pack();
        // enforces the minimum size of both frame and component
        setMinimumSize(getSize());
        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.display();
    }
}

class CustomComponent extends JComponent {

    CustomComponent() {
        setBackground(Color.YELLOW);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(100, 100);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // paint the BG.
        g.setColor(getBackground());
        g.fillRect(0,0,getWidth(),getHeight());

        int margin = 10;
        Dimension dim = getSize();

        g.setColor(Color.red);
        g.fillRect(margin, margin, dim.width-margin*2, dim.height-margin*2);
    }
}