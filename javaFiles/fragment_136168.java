import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JPanel {

    public static boolean isRecVisible = false;

    public static void main(String[] args) {
        createGui();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        if (isRecVisible) {
            g2d.drawRect(10, 10, 200, 200);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    }

    public static void createGui() {
        int frameWidth = 550;
        int frameHeight = 400;

        GUI drawRec = new GUI();
        drawRec.setBackground(Color.LIGHT_GRAY);

        JFrame f = new JFrame("Rectangle");
        JPanel p = new JPanel();
        JButton addRec = new JButton("Add Rectangle");
        JButton removeRec = new JButton("Remove Rectangle");
        JButton colorRec = new JButton("Color Rectangle");

        f.add(p, BorderLayout.PAGE_START);
        p.add(addRec);
        p.add(removeRec);
        p.add(colorRec);
        f.add(drawRec);

        f.setSize(frameWidth, frameHeight);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        addRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRecVisible = true;
                drawRec.repaint();
            }
        });

        removeRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRecVisible = false;
                drawRec.repaint();
            }
        });
    }
}