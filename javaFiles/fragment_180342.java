import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {//extends JFrame {

    public Test() {
        initialize();
    }

    private void initialize() {
        JFrame frame = new JFrame();
        //frame.setBounds(100, 100, 600, 600);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().setLayout(null);
        frame.getContentPane().add(new Display());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Test window = new Test();
    }

    public class Display extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 600);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, 100, 100);
        }

        // Not sure what benefit this provides
        //public void reDraw() {
        //    repaint();
        //}
    }
}