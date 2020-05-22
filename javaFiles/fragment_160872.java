import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame implements ActionListener {

    JButton button;
    boolean paint = false;
    int x, y;
    int[] iToken = initArray();

    public Test() {

        super("Test");

        button = new JButton("GO");
        button.setBounds(500, 100, 50, 50);
        button.addActionListener(this);
        add(button, BorderLayout.SOUTH);
        add(new DrawPanel());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setResizable(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            paint = true;
            repaint();
        }
    }

    private int[] initArray() {
        String text = "200 300 250 150 400 100";
        String[] token = text.split("\\W");
        int[] itoken = new int[token.length];
        int i = 0;
        for (String str : token) {
            itoken[i++] = Integer.parseInt(str);
        }
        return itoken;
    }

    public class DrawPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (paint) {
                for (int i = 0; i < iToken.length; i += 2) {
                    x = iToken[i];
                    y = iToken[i + 1];
                    g.drawOval(x - 5, y - 5, 10, 10);
                }
            }
        }

        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test();
            }
        });
    }
}