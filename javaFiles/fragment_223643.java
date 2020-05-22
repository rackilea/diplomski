import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI2 {

    JButton button = new JButton("YO");

    public GUI2() {
        button.addActionListener(new Action());
        JFrame frame = new JFrame("Game");
        frame.add(new DrawPanel(), BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class DrawPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(250, 250, 200, 100);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI2();
            }
        });
    }

    static class Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }
}