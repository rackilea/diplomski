import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainCode {

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainView fc = new MainView();
            }
        });
    }

    private static class MainView implements ActionListener {

        private JFrame f = new JFrame();
        private JButton colorButton = new JButton("Color");
        private JButton quitButton = new JButton("Quit");
        private JButton infoButton = new JButton("Info");
        private JLabel x_loc = new JLabel("X:");
        private JLabel y_loc = new JLabel("Y:");
        private JLabel w_label = new JLabel("Width:");
        private JLabel h_label = new JLabel("Height:");
        private JTextField x_loc_box = new JTextField("0");
        private JTextField y_loc_box = new JTextField("0");
        private JTextField w_loc_box = new JTextField("100");
        private JTextField h_loc_box = new JTextField("100");
        private JOptionPane info1 = new JOptionPane();
        private JPanel panel1 = new JPanel();
        private JPanel panel2 = new JPanel();
        private GraphicsClass graphicsClass = new GraphicsClass();

        public MainView() {
            panel1.add(x_loc);
            panel1.add(x_loc_box);
            panel1.add(y_loc);
            panel1.add(y_loc_box);
            panel1.add(w_label);
            panel1.add(w_loc_box);
            panel1.add(h_label);
            panel1.add(h_loc_box);
            colorButton.addActionListener(this);
            quitButton.addActionListener(this);
            infoButton.addActionListener(this);
            panel2.add(colorButton);
            panel2.add(quitButton);
            panel2.add(infoButton);
            f.add(panel1, BorderLayout.NORTH);
            f.add(graphicsClass, BorderLayout.CENTER);
            f.add(panel2, BorderLayout.SOUTH);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("Graphics Toolbox v2");
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == infoButton) {
                JOptionPane.showMessageDialog(f, "hahahahahaha");
            } else if (e.getSource() == quitButton) {
                System.exit(0);
            } else if (e.getSource() == colorButton) {
                graphicsClass.randomColor();
                graphicsClass.repaint();
            }
        }
    }

    private static class GraphicsClass extends JPanel {

        private static final int SIZE = 128;
        private static final Random r = new Random();
        private Color color = Color.green;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(SIZE, SIZE);
        }

        public void randomColor() {
            this.color = new Color(r.nextInt());
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            int w = getWidth();
            int h = getHeight();
            g.fillArc(0, h / 4, w, h, 45, 90);
        }
    }
}